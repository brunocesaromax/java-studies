package com.example.GlobalExceptionHandling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc // Notação necessária para capturar erro 404
public class GlobalExceptionHandlingApplication {

    public static void main(String[] args) {
        SpringApplication.run(GlobalExceptionHandlingApplication.class, args);
    }
}
