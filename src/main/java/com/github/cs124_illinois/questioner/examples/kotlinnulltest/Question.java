package com.github.cs124_illinois.questioner.examples.kotlinnulltest;

import edu.illinois.cs.cs125.questioner.lib.Correct;

/*
 * Return the length of a string.
 * Here for Kotlin null memory usage checking.
 */

@Correct(name = "Kotlin Null Test", author = "challen@illinois.edu", version = "2022.6.0")
public class Question {
  public static int length(String test) {
    assert test != null;
    return test.length();
  }
}
