package com.javasree.ms.inventory.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class StatusCheckController {

    private Logger logger = LoggerFactory.getLogger(StatusCheckController.class);

    @Autowired
    private Environment environment;

    @GetMapping(path="/check-api", produces = "application/json")
    public String status(){
        logger.info("service API is working fine:"+environment.getProperty("local.server.port"));
        return "service API is working fine:"+environment.getProperty("local.server.port");
    }
}
