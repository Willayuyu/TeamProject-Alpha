package com.example.fidledemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class FidledemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(FidledemoApplication.class, args);
  }

}
