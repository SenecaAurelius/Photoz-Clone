package com.companyname.earl.photozclone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableAutoConfiguration /*in @ComponentScan ({"myapp", "myapp.resources","myapp.services"})
include also the package which holds the Application.class in the list,

or

Simply add @EnableAutoConfiguration; it automatically recognizes all the spring beans.*/

public class PhotozCloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotozCloneApplication.class, args);
	}

}
