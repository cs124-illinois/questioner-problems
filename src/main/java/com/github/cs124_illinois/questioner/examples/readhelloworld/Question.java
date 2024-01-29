package com.github.cs124_illinois.questioner.examples.readhelloworld;

import edu.illinois.cs.cs125.jenisol.core.EdgeType;
import edu.illinois.cs.cs125.jenisol.core.ProvideFileSystem;
import edu.illinois.cs.cs125.jenisol.core.RandomType;
import edu.illinois.cs.cs125.jenisol.core.SimpleType;
import edu.illinois.cs.cs125.jenisol.core.generators.JenisolFileSystem;
import edu.illinois.cs.cs125.questioner.lib.Correct;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/*
 * Question to test filesystem generation.
 */

@Correct(name = "Read Hello World!", author = "challen@illinois.edu", version = "2023.11.0")
public class Question {
  @ProvideFileSystem
  public static void test() throws IOException {
    // mutate-disable-string-literal-trim mutate-disable-string-literal
    String greeter = new Scanner("testing.txt").useDelimiter("\\A").next();
    System.out.println(greeter);
  }

  @SimpleType
  private static final JenisolFileSystem[] SIMPLE =
      new JenisolFileSystem[] {
        new JenisolFileSystem(
            Map.of("testing.txt", "Hello, world!".getBytes(StandardCharsets.UTF_8)))
      };

  @EdgeType private static final JenisolFileSystem[] EDGE = new JenisolFileSystem[] {};

  @RandomType
  private static JenisolFileSystem randomInput(Random random) {
    return new JenisolFileSystem(
        Map.of("testing.txt", ("" + random.nextInt()).getBytes(StandardCharsets.UTF_8)));
  }
}
