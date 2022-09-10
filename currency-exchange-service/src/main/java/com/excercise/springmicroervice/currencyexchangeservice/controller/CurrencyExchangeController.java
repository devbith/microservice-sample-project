package com.excercise.springmicroervice.currencyexchangeservice.controller;

import com.excercise.springmicroervice.currencyexchangeservice.bean.CurrencyExchange;
import com.excercise.springmicroervice.currencyexchangeservice.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeService currencyExchangeService;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchange(@PathVariable String from, @PathVariable String to) {
        final String port = environment.getProperty("local.server.port");
        Optional<CurrencyExchange> currencyExchangeOptional = currencyExchangeService.findByFromAndTo(from, to);
        if (currencyExchangeOptional.isPresent()) {
            CurrencyExchange currencyExchange = currencyExchangeOptional.get();
            currencyExchange.setEnvironment(port);
            return currencyExchange;
        }
        throw new RuntimeException("Currency not found");
    }
}