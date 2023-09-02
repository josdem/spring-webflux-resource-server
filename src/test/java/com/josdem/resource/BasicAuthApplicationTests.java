package com.josdem.resource;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@SpringBootTest
@RequiredArgsConstructor
class BasicAuthApplicationTests {

  private final ApplicationContext applicationContext;

  @Test
  @DisplayName("it loads the application")
  void shouldLoadContext(TestInfo testInfo) {
    log.info("Running: {}", testInfo.getDisplayName());
    assertNotNull(applicationContext, "should have an application context");
  }
}
