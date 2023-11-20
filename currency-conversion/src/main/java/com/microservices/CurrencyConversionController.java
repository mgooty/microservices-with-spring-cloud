package com.microservices;

import jakarta.annotation.Resource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

    @Resource
    private Environment environment;

    @Resource
    private CurrencyExchangeProxy proxy;

    @GetMapping("/currency-exchange/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionResource getConversionMultiple(@PathVariable String from,
                                                          @PathVariable String to,
                                                          @PathVariable BigDecimal quantity) {
        CurrencyConversionResource exchangeResponse = proxy.getConversionMultiple(from, to);

        BigDecimal totalAmount = exchangeResponse.conversionMultiple().multiply(quantity);
        return new CurrencyConversionResource(from, to, exchangeResponse.conversionMultiple(), totalAmount, environment.getProperty("local.server.port"));
    }

}
