package com.mehedi.jpa;

import com.mehedi.jpa.entity.Person;
import com.mehedi.jpa.repository.CourseRepository;
import com.mehedi.jpa.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class JpaApplication {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository courseRepository;
	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

}
