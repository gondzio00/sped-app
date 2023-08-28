package com.dnlo.app;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class AppApplication {


    public static void main(String[] args) throws IOException, InvalidFormatException {
        SpringApplication.run(AppApplication.class, args);
    }

}
