package com.site.card.site;

import com.site.card.site.entities.Card;
import com.site.card.site.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {


	@Autowired
	CardRepository cardRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Card lamball = new Card(1,"Lamball", "Just a sheep", "Neutral", "Neutral", 50, 50, 1);
		Card cattiva = new Card(2,"Cattiva", "Just a cat", "Neutral", "Neutral", 50, 55, 2);
		cardRepository.save(lamball);
		cardRepository.save(cattiva);

	}
}
