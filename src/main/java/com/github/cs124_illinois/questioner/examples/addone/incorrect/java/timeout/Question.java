package com.github.cs124_illinois.questioner.examples.addone.incorrect.java.timeout;

import edu.illinois.cs.cs125.questioner.lib.Incorrect;

@Incorrect(reason = "linecount")
public class Question {
  int addOne(int value) {
    int j = 0;
    for (int i = 0; i < 1024; i++) {
      j++;
    }
    return value + 1;
  }
}
