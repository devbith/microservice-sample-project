package com.excercise.springmicroervice.currencyconversionservice.proxy;

import com.excercise.springmicroervice.currencyconversionservice.dto.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Kubernetes automatically creates few environment variables for the deployed service in pod
 * If a service is deployed with app name 'currency-exchange' then
 * It will create env variables with service name as prefix
 * Example: CURRENCY_EXCHANGE_SERVICE_HOST which get IP as the value
 *
 * We could use the env variable created by k8s for service deployed and use it in feign-client url
 * //@FeignClient(name = "currency-exchange", url = "${CURRENCY_EXCHANGE_SERVICE_HOST:http://localhost}:8000")
 */


@FeignClient(name = "currency-exchange", url = "${CURRENCY_EXCHANGE_URL:http://localhost}:8000")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    CurrencyConversion calculateConversion(@PathVariable String from, @PathVariable String to);
}
