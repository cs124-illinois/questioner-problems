package com.examples.testing.testmemoizationdefense;

import edu.illinois.cs.cs125.questioner.lib.Correct;
import edu.illinois.cs.cs125.questioner.lib.Wrap;

/*
 * Testing class size based memoization defense.
 */

@Correct(name = "Test Memoization Defense", version = "2023.10.0", author = "challen@illinois.edu")
@Wrap
public class Question {
  int returnValue(int value) {
    return value;
  }
}
