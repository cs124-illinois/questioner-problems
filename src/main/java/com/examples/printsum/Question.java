package com.examples.printsum;

import edu.illinois.cs.cs125.questioner.lib.Correct;

/*
 * Given two `int` variables `first` and `second` that are already declared and initialized,
 * print their sum.
 */

@Correct(name = "Print Sum", author = "challen@illinois.edu", version = "2021.6.0", maxDeadCode = 2)
public class Question {
  public static void printSum(int first, int second) {
    // TEMPLATE_START
    System.out.println(first + second);
    // TEMPLATE_END
  }
}
