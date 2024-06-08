package com.krishnavyas.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CurrencyExchangeController {

	private Logger logger=LoggerFactory.getLogger(CurrencyExchangeController.class);

	@Autowired
	private Environment environment;

	@Autowired
	private CurrencyExchangeRepository repository;

	// public CurrencyExchangeController(CurrencyExchange currencyExchange) {
//		// TODO Auto-generated constructor stub
//		this.currencyExchange=currencyExchange;
//	}
// INFO [currency-exchange-service,2bcbdd877a4188469c72759f1d34559d,d90ac0c8f0ae39da] 2848: logging for trace check

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {

		logger.info("logging for trace check");
		CurrencyExchange currencyExchange = repository.findByfromAndTo(from, to);

		if (currencyExchange == null)
			throw new RuntimeException("unable to find data for " + from + " to " + to);

		String port = environment.getProperty("local.server.port");
		currencyExchange.setEnvironment(port);
		return currencyExchange;
	}

}
