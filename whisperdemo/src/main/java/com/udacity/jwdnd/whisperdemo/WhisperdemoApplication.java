package com.udacity.jwdnd.whisperdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@SpringBootApplication //(exclude={DataSourceAutoConfiguration.class})
public class WhisperdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhisperdemoApplication.class, args);
	}

}
