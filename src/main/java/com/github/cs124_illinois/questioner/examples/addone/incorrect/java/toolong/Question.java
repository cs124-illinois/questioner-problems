package com.github.cs124_illinois.questioner.examples.addone.incorrect.java.toolong;

import edu.illinois.cs.cs125.questioner.lib.Incorrect;

@Incorrect(reason = "toolong")
public class Question {
  int addOne(int value) {
    int toReturn = value + 1;
    toReturn -= 1;
    toReturn += 1;
    toReturn -= 1;
    toReturn += 1;
    toReturn -= 1;
    toReturn += 1;
    return toReturn;
  }
}
