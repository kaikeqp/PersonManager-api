package com.project.person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.project.person.controller", "com.project.person.service"})
//@EntityScan("com.project.person.models")
//@EnableJpaRepositories("com.project.person.repository")
public class PersonApplication {

	public static void main(String[] args) {
				SpringApplication.run(PersonApplication.class, args);
	}
}
