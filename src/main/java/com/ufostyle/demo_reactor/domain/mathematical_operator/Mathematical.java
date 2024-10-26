package com.ufostyle.demo_reactor.domain.mathematical_operator;

import com.ufostyle.demo_reactor.domain.models.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Mathematical {

    private static final Logger log = LoggerFactory.getLogger(Mathematical.class);

    public void average() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Jostin", "Martinez", 24));
        persons.add(new Person(2, "Marcos", "Basurto", 26));
        persons.add(new Person(3, "Isabel", "Nuñez", 28));

        Flux.fromIterable(persons)
                .collect(Collectors.averagingInt(Person::getAge))
                .subscribe(person -> log.info(person.toString()));
    }

    public void count() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Jostin", "Martinez", 24));
        persons.add(new Person(2, "Marcos", "Basurto", 26));
        persons.add(new Person(3,"Isabel", "Nuñez", 28));

        Flux.fromIterable(persons)
                .count()
                .subscribe(person -> log.info(person.toString()));
    }

    public void min() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Jostin", "Martinez", 24));
        persons.add(new Person(2, "Marcos", "Basurto", 26));
        persons.add(new Person(3, "Isabel", "Nuñez", 28));

        Flux.fromIterable(persons)
                .collect(Collectors.minBy(Comparator.comparing(Person::getAge)))
                .subscribe(person -> log.info(person.get().toString()));
    }

    public void sum() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Jostin", "Martinez", 24));
        persons.add(new Person(2, "Marcos", "Basurto", 26));
        persons.add(new Person(3, "Isabel", "Nuñez", 28));

        Flux.fromIterable(persons)
                .collect(Collectors.summingInt(Person::getAge))
                .subscribe(person -> log.info("Suma: " + person));
    }

    public void summarizing() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Jostin", "Martinez", 24));
        persons.add(new Person(2, "Marcos", "Basurto", 26));
        persons.add(new Person(3, "Isabel", "Nuñez", 28));

        Flux.fromIterable(persons)
                .collect(Collectors.summarizingInt(Person::getAge))
                .subscribe(person -> log.info("Resume: " + person));
    }
}
