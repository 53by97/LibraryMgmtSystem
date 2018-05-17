package com.ct.lms.spring.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ct.lms.spring")
public class LibraryMgmtSystemMain {

	public static void main(String[] args) {
		SpringApplication.run(LibraryMgmtSystemMain.class, args);
	}

}