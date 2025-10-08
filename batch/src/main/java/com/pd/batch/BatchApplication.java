package com.pd.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SpringBootApplication
public class BatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(BatchApplication.class, args);
    }

    @Bean
    FlatFileItemReader<Dog> dogFlatFileItemReader(@Value("file:///Users/apple/clone/batch/dog.csv") Resource csv) throws IOException {
        String contentAsString = csv.getContentAsString(Charset.defaultCharset());
        System.out.println(contentAsString);

        return new FlatFileItemReaderBuilder<Dog>()
                .resource(csv)
                .delimited().delimiter(",")
                .names("id", "name", "description", "dob", "owner", "gender", "image")
                .linesToSkip(1)
                .name("dogFlatFile")
                .fieldSetMapper(fieldSet -> new Dog(fieldSet.readInt("id"), fieldSet.readString("name"), fieldSet.readString("description"))
                )
                .build();
    }

    @Bean
    Step step1(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager,
               FlatFileItemReader<Dog> dogFlatFileItemReader,
               JdbcBatchItemWriter<Dog> dogJdbcBatchItemWriter) {
        return new StepBuilder("step1", jobRepository)
                .<Dog,Dog>chunk(10, platformTransactionManager)
                .reader(dogFlatFileItemReader)
                //.processor(get)
                .writer(dogJdbcBatchItemWriter)
                .build();
    }

//    @Bean
//    ItemWriter<Dog> dogItemWriter(){
//        return chunk-> chunk.forEach(System.out::println);
//    }
    @Bean
    Job job(JobRepository jobRepository,Step step) {
        return new JobBuilder("dog_etl_job", jobRepository)
                .start(step)
                .incrementer(new RunIdIncrementer())
                .build();
    }

    record Dog(int id, String name, String description) {
    }

    @Bean
    JdbcBatchItemWriter<Dog> dogJdbcBatchItemWriter(DataSource dataSource){
        return new JdbcBatchItemWriterBuilder<Dog>()
                .dataSource(dataSource)
                .sql("insert into dog(id,name,description) values(?,?,?)")
                .itemPreparedStatementSetter(new ItemPreparedStatementSetter<Dog>() {
                    @Override
                    public void setValues(Dog item, PreparedStatement ps) throws SQLException {
                        ps.setInt(1,item.id());
                        ps.setString(2,item.name());
                        ps.setString(3,item.description());
                    }
                }).build();
    }
}
