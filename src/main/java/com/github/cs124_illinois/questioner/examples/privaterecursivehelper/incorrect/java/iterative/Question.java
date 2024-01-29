package com.github.cs124_illinois.questioner.examples.privaterecursivehelper.incorrect.java.iterative;

import edu.illinois.cs.cs125.questioner.lib.Incorrect;

@Incorrect(reason = "recursion")
public class Question {
  private static int rangeSumHelper(int range) {
    int sum = 0;
    for (int i = 0; i <= range; i++) {
      sum += i;
    }
    return sum;
  }

  public static int rangeSum(int range) {
    if (range < 0) {
      throw new IllegalArgumentException();
    }
    return rangeSumHelper(range);
  }
}
