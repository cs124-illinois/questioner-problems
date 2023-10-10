package com.examples.counterobject;

import edu.illinois.cs.cs125.questioner.lib.Correct;

/*
 * Define and implement a `public` class `Counter`.
 * `Counter` should provide a single public constructor that accepts an `int` parameter.
 * It should also provide `increment` and `decrement` methods, both taking no parameters and
 * returning `void`.
 * `increment` should increase the stored count, while `decrement` should decrease it.
 * Finally, provide a `getValue` method that returns the stored value.
 */

@Correct(name = "Counter", author = "challen@illinois.edu", version = "2021.6.0")
public class Counter {
  private int value;

  public Counter(int setValue) {
    value = setValue;
  }

  public void increment() {
    value++;
  }

  public void decrement() {
    value--;
  }

  public int getValue() {
    return value;
  }
}
