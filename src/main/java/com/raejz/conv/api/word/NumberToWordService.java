package com.raejz.conv.api.word;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Stack;

@Service
public class NumberToWordService {
  private  final int TEN = 10;
  private  final int HUNDRED = 100;
  private final int THOUSAND = 1000;

  private Map<Integer, String> numberLookup;
  private String[] powerOfThree = {"thousand", "million", "billion", "trillion"};

  @Autowired
  public NumberToWordService(Map<Integer, String> numberLookup) {
    this.numberLookup = numberLookup;
  }

  private boolean isDigits(String number) {
    return number.matches("\\d+");
  }

  private String convertThousandLess(Integer number) {
    Stack<String> result = new Stack<>();
    int hundred = number % HUNDRED;
    if (hundred> 0 && hundred < 20) {
      result.push(numberLookup.get(hundred));
    } else {
      result.push(numberLookup.get(hundred % TEN));
      result.push(numberLookup.get(hundred / TEN * TEN));
    }

    if (number / HUNDRED > 0) {
      result.push("hundred");
      result.push(numberLookup.get(number/HUNDRED));
    }

    return printNumber(result);
  }

  private String printNumber(Stack<String> result) {
    StringBuilder sb = new StringBuilder();

    while(!result.empty()) {
      sb.append(result.pop() + " ");
    }

    return sb.toString().trim();
  }

  public NumberInWord toWords(String numString) {
    NumberInWord inWord = new NumberInWord();
    inWord.setNumString(numString);

    if (isDigits(numString)) {
      int number;
      Stack<String> result = new Stack<>();
      number = Integer.parseInt(numString);
      inWord.setStatus("ok");

      if (number == 0) {
        inWord.setNumInEnglish("zero");
        return inWord;
      }

      int i = -1;
      while (number > 0) {
        if (i >= 0 && number % THOUSAND > 0) {
          result.push(powerOfThree[i]);
        }
        result.push(convertThousandLess(number % THOUSAND));
        number /= THOUSAND;
        i++;
      }

      inWord.setNumInEnglish(printNumber(result));
      return inWord;
    } else {
      inWord.setStatus("failed");
      inWord.setNumInEnglish( "Invalid number");
      return inWord;
    }
  }
}
