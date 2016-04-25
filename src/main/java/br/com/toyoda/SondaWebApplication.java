package br.com.toyoda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class SondaWebApplication {
    
	public static void main(String[] args) {
		SpringApplication.run(SondaWebApplication.class, args);
	}
}