package com.ufostyle.demo_reactor;

import com.ufostyle.demo_reactor.domain.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoReactorApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);

	//Using Subscribe Method
	public void reactor() {
		Mono.just(new Person(1, "Jostin", "Martinez", 24))
				.doOnNext(person -> log.info("[Reactor] Person: " + person))
				.subscribe(person -> log.info("[Reactor] Person: " + person));
	}

	//Using Mono
	public void mono() {
		Mono.just(new Person(1, "Jostin", "Martinez", 24))
				.subscribe(person -> log.info(person.toString()));
	}

	//Using Flux
	public void flux() {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person(1, "Marcos", "Basurto", 26));
		persons.add(new Person(2, "Valentina", "Nappi", 27));
		persons.add(new Person(3, "Fabio", "Garcia", 28));

		Flux.fromIterable(persons).subscribe(person -> log.info(person.toString()));
	}

	//Go From Flux To Mono
	public void fluxMono() {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person(1, "Marcos", "Basurto", 26));
		persons.add(new Person(2, "Valentina", "Nappi", 27));
		persons.add(new Person(3, "Fabio", "Garcia", 28));

		Flux<Person> fx = Flux.fromIterable(persons);
		fx.collectList().subscribe(listPerson -> log.info(listPerson.toString()));
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoReactorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//reactor();
		//mono();
		//flux();
		fluxMono();
	}
}
