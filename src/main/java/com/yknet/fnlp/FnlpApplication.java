package com.yknet.fnlp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class FnlpApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(FnlpApplication.class, args);
        Environment env = context.getEnvironment();
        System.out.println(env.getProperty("spring.profiles.active") + "," + env.getProperty("server.port"));
    }
}

