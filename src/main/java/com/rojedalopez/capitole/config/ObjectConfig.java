package com.rojedalopez.capitole.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;

public class ObjectConfig {
  @Bean
  public ObjectMapper getObjectMapper() {
    return new ObjectMapper();
  }
}
