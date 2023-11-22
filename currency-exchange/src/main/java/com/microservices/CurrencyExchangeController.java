package com.microservices;

import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @Resource
    private Environment environment;

    @Resource
    private CurrencyExchangeRepository repository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchangeResource getConversionMultiple(@PathVariable String from,
                                                        @PathVariable String to) {
        logger.info("getConversionMultiple called with from {} to {}", from, to);
        CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);

        return new CurrencyExchangeResource(currencyExchange.getFrom(), currencyExchange.getTo(), currencyExchange.getConversionMultiple(), environment.getProperty("local.server.port"));
    }

}
