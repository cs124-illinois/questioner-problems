package com.github.cs124_illinois.questioner.examples.counterobject.correct.kotlin

import edu.illinois.cs.cs125.questioner.lib.AlsoCorrect

/*
 * Define and implement a class `Counter`.
 * `Counter` should provide primary constructor that accepts an `Int` parameter.
 * It should also provide `increment` and `decrement` methods, both taking no parameters and returning `Unit`.
 * `increment` should increase the stored count, while `decrement` should decrease it.
 * Finally, provide a `getValue` method that returns the stored value.
 */

@AlsoCorrect
class Counter(setValue: Int) {
  var value = setValue
    private set
  fun increment() {
    value++
  }
  fun decrement() {
    value--
  }
}