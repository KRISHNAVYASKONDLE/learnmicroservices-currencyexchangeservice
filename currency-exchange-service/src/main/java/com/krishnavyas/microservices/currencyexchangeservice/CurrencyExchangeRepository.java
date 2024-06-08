package com.krishnavyas.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long>{

	 CurrencyExchange findByfromAndTo(String from,String to);
}
