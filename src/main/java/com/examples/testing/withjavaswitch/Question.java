package com.examples.testing.withjavaswitch;

import edu.illinois.cs.cs125.jeed.core.FeatureName;
import edu.illinois.cs.cs125.jeed.core.Features;
import edu.illinois.cs.cs125.jenisol.core.FixedParameters;
import edu.illinois.cs.cs125.jenisol.core.RandomParameters;
import edu.illinois.cs.cs125.questioner.lib.CheckFeatures;
import edu.illinois.cs.cs125.questioner.lib.Correct;
import edu.illinois.cs.cs125.questioner.lib.FeatureCheckException;
import edu.illinois.cs.cs125.questioner.lib.Wrap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*
 * Test feature check using Java 14 switch expression.
 */

@Correct(
    name = "With Java Switch",
    version = "2023.12.0",
    author = "challen@illinois.edu",
    focused = true)
@Wrap
public class Question {
  String fromDay(int day) {
    return switch (day) {
      case 0 -> "Monday"; // mutate-disable-remove-statement
      case 1 -> "Tuesday"; // mutate-disable-remove-statement
      case 2 -> "Wednesday"; // mutate-disable-remove-statement
      case 3 -> "Thursday"; // mutate-disable-remove-statement
      case 4 -> "Friday"; // mutate-disable-remove-statement
      case 5 -> "Saturday"; // mutate-disable-remove-statement
      case 6 -> "Sunday"; // mutate-disable-remove-statement
      default -> throw new IllegalArgumentException(); // mutate-disable-remove-statement
    };
  }

  @FixedParameters private static final List<Integer> FIXED = Arrays.asList(-1, 0, 6, 7);

  @RandomParameters
  private static int randomParameters(Random random) {
    return random.nextInt(16) - 6;
  }

  @CheckFeatures
  private static List<String> checkFeatures(Features solution, Features submission) {
    if (submission.getFeatureMap().containsKey(FeatureName.IF_STATEMENTS)) {
      throw new FeatureCheckException("Submission uses an if-else statement");
    }
    return new ArrayList<>();
  }
}
