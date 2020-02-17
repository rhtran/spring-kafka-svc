package com.raejz.conv.api.word;

import com.raejz.conv.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public class NumberToWordServiceTest {

  @Autowired
  private Map<Integer, String> numberLookup;

  private NumberToWordService numberToWordService;

  @BeforeEach
  public void setUp() {
    numberToWordService = new NumberToWordService(numberLookup);
  }

  @Test
  public void testToWords() {
    String[][] testCases = {{"Invalid number", "1l3444403"},
            {"zero", "0"}, {"one", "1"}, {"fourteen", "14"},
            {"twenty", "20"}, {"twenty one", "21"}, {"thirty two", "32"},
            {"two hundred two", "202"}, {"five hundred", "500"}, {"five thousand", "5000"},
            {"five hundred nineteen", "519"},
            {"two thousand two hundred two", "2202"}, {"five million", "5000000"},
            {"twelve million three hundred forty five thousand six hundred seventy eight", "12345678"}};

    for (int i = 0; i < testCases.length; i++) {
      assertEquals(testCases[i][0], numberToWordService.toWords(testCases[i][1]).getNumInEnglish());
    }
  }
}
