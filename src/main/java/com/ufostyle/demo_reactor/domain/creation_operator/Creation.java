package com.ufostyle.demo_reactor.domain.creation_operator;

import com.ufostyle.demo_reactor.domain.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Creation {

    private static final Logger log = LoggerFactory.getLogger(Creation.class);

    public void justFrom() {
        Mono.just(new Person(1, "Jostin", "Martinez", 26));
        //Flux.fromIterable(collection);
    }

    public void empty() {
        Mono.empty();
        Flux.empty();
    }

    public void range() {
        Flux.range(0, 3)
                .doOnNext(i -> log.info("i: " + i))
                .subscribe();
    }

    public void repeat() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Marcos", "Basurto", 26));
        persons.add(new Person(2, "Valentina", "Nappi", 27));
        persons.add(new Person(3, "Fabio", "Garcia", 28));

        /*Flux.fromIterable(persons)
                .repeat(1)
                .subscribe(person -> log.info(person.toString()));*/

        Mono.just(new Person(1, "Marcos", "Basurto", 26))
                .repeat(2)
                .subscribe(person -> log.info(person.toString()));
    }
}
