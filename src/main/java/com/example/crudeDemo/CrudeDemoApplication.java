package com.example.crudeDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

import javax.sql.DataSource;

@SpringBootApplication()
public class CrudeDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(CrudeDemoApplication.class, args);

	}

}




