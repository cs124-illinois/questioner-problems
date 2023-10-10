package com.examples.equals88;

import edu.illinois.cs.cs125.jenisol.core.FixedParameters;
import edu.illinois.cs.cs125.jenisol.core.RandomParameters;
import edu.illinois.cs.cs125.questioner.lib.Correct;
import edu.illinois.cs.cs125.questioner.lib.Wrap;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*
 * Write a method named `equals88` that returns `true` if its `int` argument is equal to 88,
 * our magic number.
 */

@Correct(name = "Equals 88", author = "challen@illinois.edu", version = "2021.6.0")
@Wrap
public class Question {
  boolean equals88(int value) {
    return value == 88;
  }

  @FixedParameters private static final List<Integer> FIXED = Arrays.asList(88, 188, 888, 8);

  @RandomParameters
  private static int randomInts(Random random) {
    if (random.nextBoolean()) {
      return 88;
    } else {
      return random.nextInt();
    }
  }
}
