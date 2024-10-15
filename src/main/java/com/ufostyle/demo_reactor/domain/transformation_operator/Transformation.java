package com.ufostyle.demo_reactor.domain.transformation_operator;

import com.ufostyle.demo_reactor.domain.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Transformation {

    private static final Logger log = LoggerFactory.getLogger(Transformation.class);

    //Using Map Operator
    public void map() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Jostin", "Martinez", 24));
        persons.add(new Person(2, "Marcos", "Basurto", 26));
        persons.add(new Person(3, "Valentina", "Nappi", 28));

        Flux.fromIterable(persons)
                .map(person -> {
                   person.setAge(person.getAge() + 10);
                   return person;
                })
                .subscribe(person -> log.info(person.toString()));

        Flux<Integer> fx = Flux.range(0, 10);
        Flux<Integer> fx2 = fx.map(x -> x + 10);
        fx2.subscribe(x -> log.info("x: " + x));
    }

    //Using FlatMap Operator
    public void flatMap() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Jostin", "Martinez", 24));
        persons.add(new Person(2, "Marcos", "Basurto", 26));
        persons.add(new Person(3, "Valentina", "Nappi", 28));

        Flux.fromIterable(persons)
                .flatMap(person -> {
                    person.setAge(person.getAge() + 10);
                    return Mono.just(person);
                })
                .subscribe(person -> log.info(person.toString()));
    }

    public void groupBy() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Jostin", "Martinez", 24));
        persons.add(new Person(1, "Marcos", "Basurto", 26));
        persons.add(new Person(3, "Valentina", "Nappi", 28));

        Flux.fromIterable(persons)
                .groupBy(Person::getIdPerson)
                .flatMap(idFlux -> idFlux.collectList())
                .subscribe(idPerson -> log.info(idPerson.toString()));
    }
}
