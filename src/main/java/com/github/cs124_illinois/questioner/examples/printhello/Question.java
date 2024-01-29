package com.github.cs124_illinois.questioner.examples.printhello;

import edu.illinois.cs.cs125.jenisol.core.Limit;
import edu.illinois.cs.cs125.questioner.lib.Correct;

/*
 * Print "Hello!" without the quotes.
 */

@Correct(name = "Print Hello", author = "challen@illinois.edu", version = "2022.7.0")
public class Question {
  @Limit(1)
  public static void printHello() {
    // TEMPLATE_START
    System.out.println("Hello!");
    // TEMPLATE_END
  }
}
