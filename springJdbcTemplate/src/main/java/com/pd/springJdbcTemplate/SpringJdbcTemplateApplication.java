package com.pd.springJdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class SpringJdbcTemplateApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private Tserv tservr;


	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcTemplateApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		System.out.println(" starting " );

		jdbcTemplate.queryForList("select name from public.employee",String.class)
				.forEach(System.out::println);


		jdbcTemplate.query("select * from public.employee"
				,new BeanPropertyRowMapper<>(Emp.class))
				.forEach(System.out::println);


		ap2();
	}

	private void ap1() {

		// loop
		// send all req at a time
		// select if not allocated
		// and then add the user id random

		for (int i = 0; i <100; i++) {

			int finalI = i;
			Thread t1= new Thread(()->{
				System.out.println("SpringJdbcTemplateApplication.ap1 "+ finalI);
				List<Map<String,Object>> dataMap = jdbcTemplate.queryForList("select * from public.seat_allocation where user_id is null order by id limit 1");
				System.out.println("dataMap.get(\"id\") = " + dataMap.getFirst().get("id"));
				jdbcTemplate.update("update public.seat_allocation set user_id = " +finalI + " where id="+dataMap.getFirst().get("id"));

            });
			t1.start();


		}
	}
	private void ap2() {

		// loop
		// send all req at a time
		// select if not allocated
		// and then add the user id random

		for (int i = 0; i <100; i++) {

			int finalI = i;
			Thread t1= new Thread(()->{
				tservr.extracted(finalI);

			});
			t1.start();


		}
	}

}
