package com.github.cs124_illinois.questioner.examples.recursivefactorial;

import edu.illinois.cs.cs125.jenisol.core.FixedParameters;
import edu.illinois.cs.cs125.jenisol.core.RandomParameters;
import edu.illinois.cs.cs125.questioner.lib.Correct;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*
 * Write a class method that provides a recursive implementation of factorial,
 * accepting and returning `long` arguments.
 * Throw an `IllegalArgumentException` on invalid inputs.
 */

@Correct(name = "Recursive Factorial", author = "challen@illinois.edu", version = "2022.7.0")
public class Question {
  public static long factorial(long input) {
    if (input <= 0) { // mutate-disable-conditional-boundary
      throw new IllegalArgumentException();
    }
    if (input == 1) {
      return 1;
    }
    return input * factorial(input - 1);
  }

  @FixedParameters private static final List<Long> FIXED = Arrays.asList(-10L, -1L, 0L, 1L, 2L);

  @RandomParameters
  private static long randomParameters(Random random) {
    return random.nextInt(32);
  }
}
