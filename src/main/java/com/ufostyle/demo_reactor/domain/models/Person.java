package com.ufostyle.demo_reactor.domain.models;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Person {

    private Integer idPerson;
    private String firstName;
    private String lastName;
    private Integer age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(idPerson, person.idPerson);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idPerson);
    }
}
