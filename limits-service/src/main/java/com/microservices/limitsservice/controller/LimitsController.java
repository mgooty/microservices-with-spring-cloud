package com.microservices.limitsservice.controller;

import com.microservices.limitsservice.configuration.LimitsConfiguration;
import com.microservices.limitsservice.resources.Limits;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/limits")
public class LimitsController {

    @Resource
    private LimitsConfiguration limitsConfiguration;

    @GetMapping
    private Limits getLimits() {
        return new Limits(limitsConfiguration.min(), limitsConfiguration.max());
    }
}
