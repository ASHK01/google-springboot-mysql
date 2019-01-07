package com.example.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SpringBootApplication
@RestController
public class ReservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationApplication.class, args);
	}

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	 @GetMapping("/")
	  public String hello() {
		 String a = jdbcTemplate.queryForObject("select 1 from dual", String.class);
		 System.out.println();
	    return "hello world!"+ a;
	  }
	 
	 @GetMapping("/test")
	  public String hello2() {
		Integer a = jdbcTemplate.queryForObject("select count(*) from users", Integer.class);
	    return "hello world!"+ a;
	  }
}

class JDBCRunner implements ApplicationRunner {

	private final JdbcTemplate 	JdbcTemplate;
	
	JDBCRunner(JdbcTemplate JdbcTemplate) {
		this.JdbcTemplate = JdbcTemplate;
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println(this.JdbcTemplate.queryForList("select 1 from dual"));
	}
	
}
/*
@Data
@AllArgsConstructor
@NoArgsConstructor
class Reservation {
	private Long id;
	private String name;
	
}*/