package com.microservices;

import jakarta.annotation.Resource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @Resource
    private Environment environment;

    @Resource
    private CurrencyExchangeRepository repository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchangeResource getConversionMultiple(@PathVariable String from,
                                                        @PathVariable String to) {
        CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);

        return new CurrencyExchangeResource(currencyExchange.getFrom(), currencyExchange.getTo(), currencyExchange.getConversionMultiple(), environment.getProperty("local.server.port"));
    }

}
