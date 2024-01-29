package com.github.cs124_illinois.questioner.examples.printsum.incorrect.java.toomuchoutput;

import edu.illinois.cs.cs125.questioner.lib.Incorrect;

@SuppressWarnings("InfiniteLoopStatement")
@Incorrect(reason = "timeout")
public class Question {
  public static void printSum(int first, int second) {
    // TEMPLATE_START
    while (true) {
      System.out.println(first + second);
    }
    // TEMPLATE_END
  }
}
