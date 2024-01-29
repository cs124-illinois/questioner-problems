package com.github.cs124_illinois.questioner.examples.inputinterleavingtest;

import edu.illinois.cs.cs125.jenisol.core.EdgeType;
import edu.illinois.cs.cs125.jenisol.core.Limit;
import edu.illinois.cs.cs125.jenisol.core.ProvideSystemIn;
import edu.illinois.cs.cs125.jenisol.core.RandomType;
import edu.illinois.cs.cs125.jenisol.core.SimpleType;
import edu.illinois.cs.cs125.jenisol.core.generators.SystemIn;
import edu.illinois.cs.cs125.questioner.lib.Correct;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * Testing STDIN generation and interleaving.
 */

@SuppressWarnings("StringOperationCanBeSimplified")
@Correct(name = "Input Interleaving Test", author = "challen@illinois.edu", version = "2022.9.0")
public class Question {
  @ProvideSystemIn
  @Limit(1)
  public static void echo() {
    System.out.println("Hello!");
    Scanner scanner = new Scanner(System.in);
    String first = scanner.nextLine();
    System.out.println("First: " + first);
    String second = scanner.nextLine();
    System.out.println("Second: " + second);
  }

  @SimpleType
  private static final SystemIn[] SIMPLE =
      new SystemIn[] {new SystemIn(Arrays.asList("Test", "Me"))};

  @EdgeType private static final SystemIn[] EDGE = new SystemIn[] {};

  @RandomType
  private static SystemIn randomInput(Random random) {
    return new SystemIn(
        Arrays.asList(new String("" + random.nextInt()), new String("" + random.nextInt())));
  }
}
