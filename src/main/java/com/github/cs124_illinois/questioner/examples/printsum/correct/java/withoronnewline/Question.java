package com.github.cs124_illinois.questioner.examples.printsum.correct.java.withoronnewline;

import edu.illinois.cs.cs125.questioner.lib.AlsoCorrect;

@SuppressWarnings("ConstantConditions")
@AlsoCorrect
public class Question {
  public static void printSum(int first, int second) {
    // TEMPLATE_START
    if (first != second || first == second) {
      System.out.println(first + second);
    }
    // TEMPLATE_END
  }
}
