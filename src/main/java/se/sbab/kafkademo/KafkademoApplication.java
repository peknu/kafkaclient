package se.sbab.kafkademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.UnknownHostException;

@SpringBootApplication
public class KafkademoApplication {

	public static void main(String[] args) throws UnknownHostException {
		SpringApplication.run(KafkademoApplication.class, args);
	}
}
