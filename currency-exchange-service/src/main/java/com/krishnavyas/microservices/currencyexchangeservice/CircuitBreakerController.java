package com.krishnavyas.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {

	private Logger logger= LoggerFactory.getLogger(CircuitBreakerController.class);
	
	public CircuitBreakerController() {
		// TODO Auto-generated constructor stub
	}
//	2024-05-13T16:12:06.536+05:30  INFO 23524 --- [nio-8000-exec-1] c.k.m.c.CircuitBreakerController         : sample api call recieved

	@GetMapping("/sample-api")
//	@Retry(name="sample-api",fallbackMethod = "hardcodedResponse")
//	@CircuitBreaker(name="default", fallbackMethod = "hardcodedResponse")
//	@Bulkhead(name="sample-api")
	@RateLimiter(name="default")
	public String sampleApi()
	{
//		logger.info("sample api call recieved");
//		ResponseEntity<String> forEntity=new RestTemplate().getForEntity("http://localhost:8080/some-dummy", String.class);
//		return forEntity.getBody();
		return "sample api response";
	}
	
	public String hardcodedResponse(Exception ex)
	{
		return "fallback-response";
	}
	
	
	

}