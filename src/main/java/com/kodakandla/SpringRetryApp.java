package com.kodakandla;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@SpringBootApplication
public class SpringRetryApp {

	public static void main(String[] args) {
        SpringApplication.run(SpringRetryApp.class, args);
    }

}
