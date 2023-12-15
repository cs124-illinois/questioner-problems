package com.examples.testing.withrawtypes;

import edu.illinois.cs.cs125.questioner.lib.Correct;
import java.util.ArrayList;
import java.util.List;

/*
 * Test support for raw type error filtering.
 */
@SuppressWarnings("rawtypes")
@Correct(name = "Test Raw Types", version = "2023.11.0", author = "challen@illinois.edu")
public class Question {
  public static List testing() {
    return new ArrayList();
  }
}
