package com.github.cs124_illinois.questioner.examples.fancystringcompare;

import edu.illinois.cs.cs125.questioner.lib.Correct;
import edu.illinois.cs.cs125.questioner.lib.Wrap;

/*
 * Write a method `fancyCompare` that takes two `String` arguments. If the two `String`s are equal,
 * return -1.
 * Otherwise, return the length of the longer `String`.
 * You should `assert` that both inputs are not `null`.
 */

@SuppressWarnings("ManualMinMaxCalculation")
@Correct(name = "Fancy String Compare", author = "challen@illinois.edu", version = "2021.6.0")
@Wrap
public class Question {
  int fancyEquals(String first, String second) {
    assert first != null;
    assert second != null;
    if (first.equals(second)) {
      return -1;
      // mutate-disable-conditional-boundary
      // mutate-disable-modify-length-and-size
    } else if (first.length() > second.length()) {
      return first.length();
    } else {
      return second.length();
    }
  }
}
