package com.examples.addone;

import edu.illinois.cs.cs125.jenisol.core.FixedParameters;
import edu.illinois.cs.cs125.questioner.lib.Correct;
import edu.illinois.cs.cs125.questioner.lib.Wrap;
import java.util.Arrays;
import java.util.List;

/*
 * Write a method `addOne` that returns its `int` argument plus one.
 */

@Correct(name = "Add One", author = "challen@illinois.edu", version = "2021.6.0")
@Wrap
public class Question {
  // Here to avoid dead code errors in the memoization test
  @FixedParameters
  private static final List<Integer> FIXED = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

  int addOne(int value) {
    return value + 1;
  }
}
