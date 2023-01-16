package com.shreeganesh.loan.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shreeganesh.loan.app.customerEntities.Enquiry;

@SpringBootApplication
public class ShreeGaneshFinanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShreeGaneshFinanceApplication.class, args);
		System.out.println("Jai GAnesh");
		
		ObjectMapper mapper=new ObjectMapper();
		try {
			System.out.println(mapper.writeValueAsString(new Enquiry()));
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		System.out.println("Gitbash");
		System.out.println("Ashutosh");
	}

}
