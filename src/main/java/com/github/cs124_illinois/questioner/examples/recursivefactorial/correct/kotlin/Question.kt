@file:AlsoCorrect

package com.github.cs124_illinois.questioner.examples.recursivefactorial.correct.kotlin

import edu.illinois.cs.cs125.questioner.lib.AlsoCorrect

/*
 * Write a method that provides a recursive implementation of factorial, accepting and returning `Long` arguments.
 * Throw an `IllegalArgumentException` on invalid inputs.
 */

fun factorial(input: Long): Long {
  require(input > 0)
  if (input == 1L) {
    return 1
  }
  return input * factorial(input - 1)
}