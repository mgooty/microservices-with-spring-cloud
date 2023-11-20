package com.microservices;

import java.math.BigDecimal;

public record CurrencyConversionResource(String from, String to, BigDecimal conversionMultiple, BigDecimal totalAmount, String environment) {

}
