package com.vinsguru.business_search;

import com.vinsguru.business.BusinessSearchApplication;
import org.springframework.boot.SpringApplication;

public class TestBusinessSearchApplication {

	public static void main(String[] args) {
		SpringApplication.from(BusinessSearchApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
