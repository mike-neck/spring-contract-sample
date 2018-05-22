package com.example;

import java.time.ZoneOffset;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.util.Loggers;

@RestController
@RequestMapping(path = "api")
public class Handler {

  private final ZoneOffset zoneOffset;

  public Handler(final ZoneOffset zoneOffset) {
    this.zoneOffset = zoneOffset;
  }

  @SuppressWarnings("unused")
  @GetMapping(path = "/message")
  Mono<Message> echoWithTime(@RequestParam("message") final String message) {
    return Mono.just(message)
        .log(Loggers.getLogger(Handler.class))
        .map(Message::builder)
        .map(f -> f.apply(zoneOffset));
  }
}
