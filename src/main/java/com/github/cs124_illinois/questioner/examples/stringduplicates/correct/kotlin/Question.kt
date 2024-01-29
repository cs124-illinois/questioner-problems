package com.github.cs124_illinois.questioner.examples.stringduplicates.correct.kotlin

import edu.illinois.cs.cs125.questioner.lib.AlsoCorrect

/*
 * Given a `String` containing comma-separated values, write a method `detectDuplicates`
 * that returns `true` if the `String` includes duplicate values, and `false` otherwise.
 * Trim whitespace from all `String`s.
 */

@AlsoCorrect
class Question {
  fun detectDuplicates(input: String): Boolean {
    val values = mutableSetOf<String>()
    for (part in input.split(",")) {
      val current = part.trim()
      if (values.contains(current)) {
        return true
      }
      values.add(current)
    }
    return false
  }
}