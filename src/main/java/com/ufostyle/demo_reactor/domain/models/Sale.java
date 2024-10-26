package com.ufostyle.demo_reactor.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Sale {

    private Integer idSale;
    private LocalDate time;
}
