package com.ufostyle.demo_reactor.domain.filtered_operator;

import com.ufostyle.demo_reactor.domain.models.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Filtered {

    private static final Logger log = LoggerFactory.getLogger(Filtered.class);

    //Using Filter Operator
    public void filter(){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Jostin", "Martinez", 24));
        persons.add(new Person(2, "Marcos", "Basurto", 26));
        persons.add(new Person(3, "Valentina", "Nappi", 28));

        Flux.fromIterable(persons)
                .filter(person -> person.getAge() > 24)
                .subscribe(person -> log.info(person.toString()));
    }

    //Using Distinct Operator
    public void distinct() {
        Flux.fromIterable(List.of(1, 1, 2, 2))
                .distinct()
                .subscribe(list -> log.info(list.toString()));

        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Jostin", "Martinez", 24));
        persons.add(new Person(1, "Marcos", "Basurto", 26));
        persons.add(new Person(3, "Valentina", "Nappi", 28));

        Flux.fromIterable(persons)
                .distinct()
                .subscribe(person -> log.info(person.toString()));
    }

    //Using Take Operator
    public void take() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Jostin", "Martinez", 24));
        persons.add(new Person(2, "Marcos", "Basurto", 26));
        persons.add(new Person(3, "Valentina", "Nappi", 28));

        Flux.fromIterable(persons)
                .take(1)
                .subscribe(person -> log.info(person.toString()));
    }

    //Using TakeLast Operator
    public void takeLast() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Jostin", "Martinez", 24));
        persons.add(new Person(2, "Marcos", "Basurto", 26));
        persons.add(new Person(3, "Valentina", "Nappi", 28));

        Flux.fromIterable(persons)
                .takeLast(1)
                .subscribe(person -> log.info(person.toString()));
    }

    //Using Skip Operator
    public void skip() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Jostin", "Martinez", 24));
        persons.add(new Person(2, "Marcos", "Basurto", 26));
        persons.add(new Person(3, "Valentina", "Nappi", 28));

        Flux.fromIterable(persons)
                .skip(1)
                .subscribe(person -> log.info(person.toString()));
    }

    //Using SkipLast Operator
    public void skipLast() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Jostin", "Martinez", 24));
        persons.add(new Person(2, "Marcos", "Basurto", 26));
        persons.add(new Person(3, "Valentina", "Nappi", 28));

        Flux.fromIterable(persons)
                .skipLast(1)
                .subscribe(person -> log.info(person.toString()));
    }
}
