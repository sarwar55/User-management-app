package org.sarwar.becreative;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class SpringmvcRestAngular2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringmvcRestAngular2Application.class, args);
	}
}
