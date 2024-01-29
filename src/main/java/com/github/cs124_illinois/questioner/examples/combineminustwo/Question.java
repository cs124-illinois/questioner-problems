package com.github.cs124_illinois.questioner.examples.combineminustwo;

import edu.illinois.cs.cs125.jenisol.core.FixedParameters;
import edu.illinois.cs.cs125.jenisol.core.RandomParameters;
import edu.illinois.cs.cs125.jenisol.core.Two;
import edu.illinois.cs.cs125.questioner.lib.Correct;
import edu.illinois.cs.cs125.questioner.lib.Generators;
import edu.illinois.cs.cs125.questioner.lib.Wrap;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*
 * Write a function `combine` that, given two `String` arguments, returns the second appended to
 * the first.
 * Except you should omit the first two characters of each `String`.
 * For example, given `Java` and `Kotlin`, you would return `vatlin`.
 * You can assume that each `String` is of length at least two.
 */

@Correct(name = "Combine Minus Two", author = "challen@illinois.edu", version = "2021.6.0")
@Wrap
public class Question {
  String combine(String first, String second) {
    return first.substring(2) + second.substring(2);
  }

  @FixedParameters
  private static final List<Two<String, String>> FIXED =
      Arrays.asList(new Two<>("Java", "Kotlin"), new Two<>("CS125", "CS124"));

  @RandomParameters
  private static Two<String, String> randomStrings(Random random) {
    String first = Generators.randomAlphanumericStringWithLength(random, random.nextInt(32) + 2);
    String second = Generators.randomAlphanumericStringWithLength(random, random.nextInt(32) + 2);
    return new Two<>(first, second);
  }
}
