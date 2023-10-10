package com.examples.tripleequals;

import edu.illinois.cs.cs125.jenisol.core.FixedParameters;
import edu.illinois.cs.cs125.jenisol.core.RandomParameters;
import edu.illinois.cs.cs125.jenisol.core.Three;
import edu.illinois.cs.cs125.questioner.lib.Correct;
import edu.illinois.cs.cs125.questioner.lib.Generators;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*
 * Define a public class named `Squirrel`.
 * The `Squirrel` constructor should accept a `String` name, `String` tree, and `int` acorns,
 * in that order.
 * Reject `null` names and trees using `assert`, and also `assert` that acorns is greater than 0
 * and less than or equal to 24.
 * (Squirrels don't get too greedy and never acquire more acorns than that!)
 * Override equals and consider two `Squirrel` instances to be equal if they have the same name
 * and tree.
 * Do not provide getters or setters for your variables or expose them publicly.
 */

@SuppressWarnings("FieldCanBeLocal")
@Correct(name = "Squirrel Equality", version = "2022.7.0", author = "challen@illinois.edu")
public class Squirrel {
  private final String name;
  private final String tree;
  private final int acorns;

  public Squirrel(String setName, String setTree, int setAcorns) {
    assert setName != null;
    assert setTree != null;
    assert setAcorns > 0 && setAcorns <= 9;
    name = setName;
    tree = setTree;
    acorns = setAcorns;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Squirrel other)) {
      return false;
    }
    return name.equals(other.name) && tree.equals(other.tree);
  }

  @FixedParameters
  private static final List<Three<String, String, Integer>> FIXED =
      Arrays.asList(
          new Three<>("Patch", "Elm", 8),
          new Three<>(null, "Elm", 8),
          new Three<>("Patch", null, 8),
          new Three<>("Patch", "Elm", 0),
          new Three<>("Patch", "Elm", 10),
          new Three<>("Patch", "Elm", 9),
          new Three<>("Marty", "Elm", 8),
          new Three<>("Patch", "Oak", 1),
          new Three<>("Patch", "Elm", 8));

  @RandomParameters
  private static Three<String, String, Integer> randomParameters(Random random) {
    String name = Generators.randomAlphanumericString(random, 16);
    String breed = Generators.randomAlphanumericString(random, 32);
    int lives = random.nextInt(26);
    return new Three<>(name, breed, lives);
  }
}
