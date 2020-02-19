package com.raejz.conv;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig {
  @Bean
  public Map<Integer, String> numberLookup() {
    Map<Integer, String> dict = new HashMap<>();
    dict = new HashMap<>();
    // return blank for zero case logic
    dict.put(0, "");
    dict.put(1, "one");
    dict.put(2, "two");
    dict.put(3, "three");
    dict.put(4, "four");
    dict.put(5, "five");
    dict.put(6, "six");
    dict.put(7, "seven");
    dict.put(8, "eight");
    dict.put(9, "nine");
    dict.put(10, "ten");
    dict.put(11, "eleven");
    dict.put(12, "twelve");
    dict.put(13, "thirteen");
    dict.put(14, "fourteen");
    dict.put(15, "fifteen");
    dict.put(16, "sixteen");
    dict.put(17, "seventeen");
    dict.put(18, "eighteen");
    dict.put(19, "nineteen");
    dict.put(20, "twenty");
    dict.put(30, "thirty");
    dict.put(40, "forty");
    dict.put(50, "fifty");
    dict.put(60, "sixty");
    dict.put(70, "seventy");
    dict.put(80, "eighty");
    dict.put(90, "ninety");

    return dict;
  }

  @Bean
  public ObjectMapper getObjectMapper() {
   return new ObjectMapper();
  }
}
