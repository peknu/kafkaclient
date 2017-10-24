package se.sbab.kafka.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.UnknownHostException;

@SpringBootApplication
public class SpringbootKafkaClientApplication {

	public static void main(String[] args) throws UnknownHostException {
		SpringApplication.run(SpringbootKafkaClientApplication.class, args);
	}
}
