package com.github.cs124_illinois.questioner.examples.addone.incorrect.java.memorylimit;

import edu.illinois.cs.cs125.questioner.lib.Incorrect;

@Incorrect(reason = "memorylimit")
public class Question {
  private final int[] values = new int[1024];

  int addOne(int value) {
    return value + 1;
  }
}
