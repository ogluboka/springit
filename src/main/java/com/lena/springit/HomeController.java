package com.lena.springit;

import com.lena.springit.config.SpringitProperties;
import org.apache.catalina.core.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private static final Logger log = LoggerFactory.getLogger(SpringitApplication.class);

    @Autowired
    private SpringitProperties properties;

    @GetMapping("/")
    public String home() {
        return properties.getWelcomeMsg();
    }
}
