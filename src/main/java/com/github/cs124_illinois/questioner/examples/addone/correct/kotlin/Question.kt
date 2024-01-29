package com.github.cs124_illinois.questioner.examples.addone.correct.kotlin

import edu.illinois.cs.cs125.questioner.lib.AlsoCorrect

/*
 * Write a method `addOne` that returns its `Int` argument plus one.
 */

@AlsoCorrect
class Question {
  // Note that this question was originally set up a bit differently in the demo video.
  // Now Kotlin solutions that use @file:AlsoCorrect will not be templated when @Wrap is used on the solution.
  // So the Kotlin solution should follow the class design established by the Java code, even for faux-static methods.
  fun addOne(value: Int): Int {
    return value + 1
  }
}