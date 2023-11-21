package com.microservices;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
    @CircuitBreaker(name = "default", fallbackMethod = "handleFailure")
//    @Retry(name = "retry-3-and-fail", fallbackMethod = "handleFailure")
//    @RateLimiter(name = "default")
//    @Bulkhead(name = "default")
    public String sampleApiResponse() {
        logger.info("received sample api request");

        ResponseEntity<String> responseEntity = new RestTemplate().getForEntity("http://localhost:8080/dummyapi", String.class);
        return responseEntity.getBody();
    }

    private String handleFailure(Exception e) {
        logger.info("handle failure");
        return "default api response";
    }

}
