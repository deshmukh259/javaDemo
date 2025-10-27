package com.pd.springJdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringJdbcTemplateApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;


	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcTemplateApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		System.out.println(" starting " );

		jdbcTemplate.queryForList("select name from employee",String.class)
				.forEach(System.out::println);


		jdbcTemplate.queryForList("select * from employee"
				,new BeanPropertyRowMapper<>(Emp.class))
				.forEach(System.out::println);

	}
}
