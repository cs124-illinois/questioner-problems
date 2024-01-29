package com.github.cs124_illinois.questioner.examples.fancystringcompare.incorrect.badequals;

import edu.illinois.cs.cs125.questioner.lib.Incorrect;

@SuppressWarnings({"ManualMinMaxCalculation", "StringEquality"})
@Incorrect
public class Question {
  int fancyEquals(String first, String second) {
    assert first != null;
    assert second != null;
    if (first == second) {
      return -1;
    } else if (first.length() > second.length()) { // mutate-disable-conditional-boundary
      return first.length();
    } else {
      return second.length();
    }
  }
}
