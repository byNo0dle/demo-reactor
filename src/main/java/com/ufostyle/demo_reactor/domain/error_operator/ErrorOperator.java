package com.ufostyle.demo_reactor.domain.error_operator;

import com.ufostyle.demo_reactor.domain.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class ErrorOperator {

    private static final Logger log = LoggerFactory.getLogger(ErrorOperator.class);

    public void retry() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Jostin", "Martinez", 24));
        persons.add(new Person(2, "Marcos", "Basurto", 26));
        persons.add(new Person(3, "Isabel", "Nuñez", 28));

        Flux.fromIterable(persons)
                .concatWith(Flux.error(new RuntimeException("Se acaba de producir un error: ")))
                .retry(1)
                .doOnNext(person -> log.info(person.toString()))
                .subscribe();
    }

    public void errorReturn() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Jostin", "Martinez", 24));
        persons.add(new Person(2, "Marcos", "Basurto", 26));
        persons.add(new Person(3, "Isabel", "Nuñez", 28));

        Flux.fromIterable(persons)
                .concatWith(Flux.error(new RuntimeException("Se acaba de producir un error: ")))
                .onErrorReturn(new Person(0, "Valentina", "Nappi", 34))
                .subscribe(person -> log.info(person.toString()));
    }

    public void errorResume() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Jostin", "Martinez", 24));
        persons.add(new Person(2, "Marcos", "Basurto", 26));
        persons.add(new Person(3, "Isabel", "Nuñez", 28));

        Flux.fromIterable(persons)
                .concatWith(Flux.error(new RuntimeException("Se acaba de producir un error: ")))
                .onErrorResume(exception -> Mono.just(new Person(0, "Valentina", "Nappi", 34)))
                .subscribe(exception -> log.info(exception.toString()));
    }

    public void errorMap() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Jostin", "Martinez", 24));
        persons.add(new Person(2, "Marcos", "Basurto", 26));
        persons.add(new Person(3, "Isabel", "Nuñez", 28));

        Flux.fromIterable(persons)
                .concatWith(Flux.error(new RuntimeException("Se acaba de producir un error: ")))
                .onErrorMap(exception -> new InterruptedException(exception.getMessage()))
                .subscribe(exception -> log.info(exception.toString()));
    }
}
