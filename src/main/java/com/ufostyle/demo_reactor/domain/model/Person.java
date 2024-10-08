package com.ufostyle.demo_reactor.domain.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Person {

    private Integer idPerson;
    private String firstName;
    private String lastName;
    private Integer age;
}
