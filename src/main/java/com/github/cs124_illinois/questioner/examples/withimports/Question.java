package com.github.cs124_illinois.questioner.examples.withimports;

import edu.illinois.cs.cs125.questioner.lib.Correct;
import java.util.Arrays;
import java.util.List;

/*
 * Example to test use of import statements.
 */

@Correct(name = "With Imports", author = "challen@illinois.edu", version = "2022.7.0")
public class Question {
  public static List<Integer> max(int first, int second) {
    return Arrays.asList(first, second);
  }
}
