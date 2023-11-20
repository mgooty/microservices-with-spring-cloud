package com.microservices;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class CurrencyExchange {

    @Id
    private Long id;

    @Column(name = "from_currency", nullable = false)
    private String from;

    @Column(name = "to_currency",nullable = false)
    private String to;

    @Column(nullable = false)
    private BigDecimal conversionMultiple;

    @Column(nullable = true)
    private String environment;

}
