package com.github.cs124_illinois.questioner.examples.privaterecursivehelper;

import edu.illinois.cs.cs125.jenisol.core.FilterParameters;
import edu.illinois.cs.cs125.jenisol.core.SkipTest;
import edu.illinois.cs.cs125.questioner.lib.Correct;

/*
 * Testing question for recursion checks on private methods.
 */

@Correct(name = "Private Recursive Helper", author = "challen@illinois.edu", version = "2022.7.0")
public class Question {
  private static int rangeSumHelper(int range) {
    if (range == 0) {
      return 0;
    }
    return range + rangeSumHelper(range - 1);
  }

  @FilterParameters
  private static void filterRangeSum(int range) {
    if (range > 1024) {
      throw new SkipTest();
    }
  }

  public static int rangeSum(int range) {
    if (range < 0) {
      throw new IllegalArgumentException();
    }
    return rangeSumHelper(range);
  }
}
