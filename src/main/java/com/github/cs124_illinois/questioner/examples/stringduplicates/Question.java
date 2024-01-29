package com.github.cs124_illinois.questioner.examples.stringduplicates;

import edu.illinois.cs.cs125.jenisol.core.NotNull;
import edu.illinois.cs.cs125.jenisol.core.RandomParameters;
import edu.illinois.cs.cs125.questioner.lib.Correct;
import edu.illinois.cs.cs125.questioner.lib.Generators;
import edu.illinois.cs.cs125.questioner.lib.TemplateImports;
import edu.illinois.cs.cs125.questioner.lib.Wrap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/*
 * Given a non-`null` `String` containing comma-separated values, write a method `detectDuplicates`
 * that returns `true` if the `String` includes duplicate values, and `false` otherwise.
 * Trim whitespace from all `String`s.
 */

@Correct(name = "String Duplicates", author = "challen@illinois.edu", version = "2022.2.0")
@Wrap
@TemplateImports(paths = "java.util.Map, java.util.HashMap")
public class Question {
  boolean detectDuplicates(@NotNull String input) {
    Set<String> values = new HashSet<>();
    for (String part : input.split(",")) {
      String current = part.trim();
      if (values.contains(current)) {
        return true;
      }
      values.add(current);
    }
    return false;
  }

  @RandomParameters
  private static String randomParameters(Random random) {
    String[] values = new String[random.nextInt(32) + 32];
    for (int i = 0; i < values.length; i++) {
      String current = Generators.randomAlphanumericString(random, 32);
      if (random.nextBoolean()) {
        values[i] = " " + current;
      } else {
        values[i] = current + " ";
      }
    }
    if (random.nextBoolean()) {
      values[random.nextInt(values.length)] =
          new String(values[random.nextInt(values.length)].toCharArray());
    }
    return String.join(",", values);
  }
}
