package com.github.cs124_illinois.questioner.examples.addone.incorrect.java.deadcode;

import edu.illinois.cs.cs125.questioner.lib.Incorrect;

@Incorrect(reason = "deadcode")
public class Question {
  int addOne(int value) {
    if (value == 1234567) {
      return 1234568;
    }
    return value + 1;
  }
}
