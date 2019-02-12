package com.timwheeler.server;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Bean
	ApplicationRunner init(CarRepository repository) {
		return args -> {
			Stream.of("Ferrari", "Lamborghini", "Porsche", "Mercedes-Benz", "BMW", "Subaru", "Bugatti", "Tesla", "McClaren").forEach(name -> {
				Car car = new Car();
				car.setName(name);
				repository.save(car);
			});
			repository.findAll().forEach(System.out::println);
		};
	}

}


