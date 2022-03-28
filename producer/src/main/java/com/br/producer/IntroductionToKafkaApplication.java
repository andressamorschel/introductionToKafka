package com.br.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class IntroductionToKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntroductionToKafkaApplication.class, args);
	}

}
