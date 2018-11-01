package com.ssst.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication 
// @ComponentScan(basePackages={"com.ssst.calculator", "com.ssst.mvc", "com.ssst.restful"})
public class CalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculatorApplication.class, args);
	}
	
}