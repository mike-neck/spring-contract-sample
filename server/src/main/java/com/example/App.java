package com.example;

import java.time.ZoneOffset;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

  public static void main(String[] args) {
    SpringApplication.run(App.class);
  }

  @Bean
  ZoneOffset zoneOffset() {
    return ZoneOffset.ofHours(9);
  }
}
