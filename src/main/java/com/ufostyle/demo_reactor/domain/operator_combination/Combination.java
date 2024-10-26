package com.ufostyle.demo_reactor.domain.operator_combination;

import com.ufostyle.demo_reactor.domain.models.Person;
import com.ufostyle.demo_reactor.domain.models.Sale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Combination {

    private static final Logger log = LoggerFactory.getLogger(Combination.class);

    public void merge() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Jostin", "Martinez", 24));
        persons.add(new Person(2, "Marcos", "Basurto", 26));
        persons.add(new Person(3, "Isabel", "Nuñez", 28));

        List<Person> persons2 = new ArrayList<>();
        persons2.add(new Person(4, "Celia", "Halenke", 30));
        persons2.add(new Person(5, "Lana", "Rhoades", 32));
        persons2.add(new Person(6, "Valentina", "Nappi", 34));

        List<Sale> sales = new ArrayList<>();
        sales.add(new Sale(1, LocalDate.now()));

        Flux<Person> fx = Flux.fromIterable(persons);
        Flux<Person> fx2 = Flux.fromIterable(persons2);
        Flux<Sale> fx3 = Flux.fromIterable(sales);

        Flux.merge(fx, fx2, fx3)
                .subscribe(person -> log.info(person.toString()));
    }

    public void zip() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Jostin", "Martinez", 24));
        persons.add(new Person(2, "Marcos", "Basurto", 26));
        persons.add(new Person(3, "Isabel", "Nuñez", 28));

        List<Person> persons2 = new ArrayList<>();
        persons2.add(new Person(4, "Celia", "Halenke", 30));
        persons2.add(new Person(5, "Lana", "Rhoades", 32));
        persons2.add(new Person(6, "Valentina", "Nappi", 34));

        List<Sale> sales = new ArrayList<>();
        sales.add(new Sale(1, LocalDate.now()));

        Flux<Person> fx = Flux.fromIterable(persons);
        Flux<Person> fx2 = Flux.fromIterable(persons2);
        Flux<Sale> fx3 = Flux.fromIterable(sales);

        /*Flux.zip(fx, fx2, (p1, p2) -> String.format("Flux1: %s, Flux2: %s", p1, p2))
                .subscribe(lists -> log.info(lists));*/

        Flux.zip(fx, fx2, fx3)
                .subscribe(lists -> log.info(lists.toString()));
    }

    public void zipWith() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Jostin", "Martinez", 24));
        persons.add(new Person(2, "Marcos", "Basurto", 26));
        persons.add(new Person(3, "Isabel", "Nuñez", 28));

        List<Person> persons2 = new ArrayList<>();
        persons2.add(new Person(4, "Celia", "Halenke", 30));
        persons2.add(new Person(5, "Lana", "Rhoades", 32));
        persons2.add(new Person(6, "Valentina", "Nappi", 34));

        List<Sale> sales = new ArrayList<>();
        sales.add(new Sale(1, LocalDate.now()));

        Flux<Person> fx = Flux.fromIterable(persons);
        Flux<Person> fx2 = Flux.fromIterable(persons2);
        Flux<Sale> fx3 = Flux.fromIterable(sales);

        fx.zipWith(fx2, (p1, p2) -> String.format("Flux1: %s, Flux2: %s", p1, p2))
                .subscribe(lists -> log.info(lists.toString()));
    }
}
