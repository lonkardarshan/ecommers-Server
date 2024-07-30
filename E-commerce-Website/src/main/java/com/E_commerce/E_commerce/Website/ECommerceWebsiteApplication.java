package com.E_commerce.E_commerce.Website;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
public class ECommerceWebsiteApplication {
	public static void main(String[] args) {
		SpringApplication.run(ECommerceWebsiteApplication.class, args);
		System.out.println("Application Running");
	}
}
