package com.jh.kdh_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class KdhProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(KdhProjectApplication.class, args);
    }

}
