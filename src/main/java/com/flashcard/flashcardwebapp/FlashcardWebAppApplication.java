package com.flashcard.flashcardwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class FlashcardWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlashcardWebAppApplication.class, args);
	}

}

