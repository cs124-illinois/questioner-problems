package com.github.cs124_illinois.questioner.examples.recursivefactorial.incorrect.java.iterative;

import edu.illinois.cs.cs125.questioner.lib.Incorrect;

@Incorrect(reason = "recursion")
public class Question {
  public static long factorial(long input) {
    if (input <= 0) {
      throw new IllegalArgumentException();
    }
    long result = 1;
    for (long multiplier = 2; multiplier <= input; multiplier++) {
      result *= multiplier;
    }
    return result;
  }
}
