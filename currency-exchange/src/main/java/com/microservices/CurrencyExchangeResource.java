package com.microservices;

import java.math.BigDecimal;

public record CurrencyExchangeResource(String from, String to, BigDecimal conversionMultiple, String environment) {
}
