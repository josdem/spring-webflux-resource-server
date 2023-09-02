package com.josdem.resource.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ResourceController {

  @GetMapping("/")
  public Mono<String> index(@AuthenticationPrincipal Jwt jwt) {
    return Mono.just(String.format("Hello, %s!", jwt.getSubject()));
  }

  @GetMapping("/message")
  public Mono<String> message() {
    return Mono.just("secret message");
  }

  @PostMapping("/message")
  public Mono<String> createMessage(@RequestBody String message) {
    return Mono.just(String.format("Content: %s", message));
  }
}
