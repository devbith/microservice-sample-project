package com.excercise.springmicroervice.currencyexchangeservice.controller;

import com.excercise.springmicroervice.currencyexchangeservice.model.CurrencyExchange;
import com.excercise.springmicroervice.currencyexchangeservice.service.CurrencyExchangeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CurrencyExchangeController {

    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeService currencyExchangeService;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchange(@PathVariable String from, @PathVariable String to) {
        logger.info("retrieve value from {} to {}", from, to);

        final String port = environment.getProperty("local.server.port");
        final String host = environment.getProperty("HOSTNAME");
        final String version = "v2";

        Optional<CurrencyExchange> currencyExchangeOptional = currencyExchangeService.findByFromAndTo(from, to);
        if (currencyExchangeOptional.isPresent()) {
            CurrencyExchange currencyExchange = currencyExchangeOptional.get();
            currencyExchange.setEnvironment(port +":"+host+"  "+version);
            return currencyExchange;
        }
        throw new RuntimeException("Currency not found");
    }
}