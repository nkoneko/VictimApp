package com.example.victim;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class VictimApplication {
    static final Logger logger = LogManager.getLogger(VictimApplication.class);

	public static void main(String[] args) {
        //System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase", "true");
		SpringApplication.run(VictimApplication.class, args);
	}

    @GetMapping("/hello")
    public String hello(
            @RequestHeader(name = "User-Agent", required=false) String userAgent,
            @RequestParam(value = "name", defaultValue = "world") String name
    ) {
        logger.warn("User-Agent:" + userAgent);
        return String.format("Hello, %s!", name);
    }
}
