package com.github.cs124_illinois.questioner.examples.addoneclass;

import edu.illinois.cs.cs125.questioner.lib.Correct;

/*
 * Write a class named `Question` with a single `static` method `addOne` that returns its `int`
 * argument plus one.
 */

@Correct(name = "Add One Class", author = "challen@illinois.edu", version = "2021.6.0")
public class Question {
  public static int addOne(int value) {
    return value + 1;
  }
}
