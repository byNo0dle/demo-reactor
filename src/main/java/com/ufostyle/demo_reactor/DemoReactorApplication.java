package com.ufostyle.demo_reactor;

import com.ufostyle.demo_reactor.domain.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class DemoReactorApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);

	//Using Subscribe Method
	public void reactor() {
		Mono.just(new Person(1, "Jostin", "Martinez", 24))
				.doOnNext(person -> log.info("[Reactor] Person: " + person))
				.subscribe(person -> log.info("[Reactor] Person: " + person));
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoReactorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		reactor();
	}
}
