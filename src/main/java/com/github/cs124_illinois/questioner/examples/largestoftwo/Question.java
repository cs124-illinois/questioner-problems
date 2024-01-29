package com.github.cs124_illinois.questioner.examples.largestoftwo;

import edu.illinois.cs.cs125.questioner.lib.Correct;
import edu.illinois.cs.cs125.questioner.lib.Wrap;

/*
 * Write a method `larger` that returns the larger of two `int` arguments.
 */
@SuppressWarnings("ManualMinMaxCalculation")
@Correct(name = "Larger of Two", author = "challen@illinois.edu", version = "2021.6.0")
@Wrap
public class Question {
  int larger(int first, int second) {
    if (first > second) { // mutate-disable-conditional-boundary
      return first;
    } else {
      return second;
    }
  }
}
