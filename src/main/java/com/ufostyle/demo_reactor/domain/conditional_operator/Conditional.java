package com.ufostyle.demo_reactor.domain.conditional_operator;

import com.ufostyle.demo_reactor.domain.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Conditional {

    private static final Logger log = LoggerFactory.getLogger(Conditional.class);

    public void defaultIfEmpty() {
        Mono.just(new Person(1, "Jostin", "Martinez", 24))
        //Mono.empty()
        //Flux.empty()
                .defaultIfEmpty(new Person(0, "Valentina", "Nappi", 34))
                .subscribe(person -> log.info(person.toString()));
    }

    public void takeUntil() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Jostin", "Martinez", 24));
        persons.add(new Person(2, "Marcos", "Basurto", 26));
        persons.add(new Person(3, "Isabel", "Nuñez", 28));

        Flux.fromIterable(persons)
                .takeUntil(person -> person.getAge() > 24)
                .subscribe(person -> log.info(person.toString()));
    }

    public void timeOut() throws InterruptedException {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Jostin", "Martinez", 24));
        persons.add(new Person(2, "Marcos", "Basurto", 26));
        persons.add(new Person(3, "Isabel", "Nuñez", 28));

        Flux.fromIterable(persons)
                .delayElements(Duration.ofSeconds(1))
                .timeout(Duration.ofSeconds(2))
                .subscribe(person -> log.info(person.toString()));

        Thread.sleep(10000);
    }
}
