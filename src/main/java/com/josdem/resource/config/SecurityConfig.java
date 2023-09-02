package com.josdem.resource.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebFluxSecurity
@Configuration
public class SecurityConfig {

  @Bean
  SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
    http.authorizeExchange(
            (authorize) ->
                authorize
                    .pathMatchers("/message/**")
                    .hasAuthority("SCOPE_write")
                    .anyExchange()
                    .authenticated())
        .oauth2ResourceServer((resourceServer) -> resourceServer.jwt(withDefaults()));
    return http.build();
  }
}
