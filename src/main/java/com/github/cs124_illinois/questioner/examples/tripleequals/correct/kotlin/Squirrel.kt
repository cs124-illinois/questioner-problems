package com.github.cs124_illinois.questioner.examples.tripleequals.correct.kotlin

import edu.illinois.cs.cs125.questioner.lib.AlsoCorrect

/*
 * Kotlin version to test double init.
 */

@Suppress("EqualsOrHashCode", "CanBeParameter")
@AlsoCorrect
class Squirrel(private val name: String, private val tree: String, private val acorns: Int) {
  init {
    require(acorns > 0)
  }
  init {
    require(acorns <= 9)
  }
  override fun equals(other: Any?): Boolean {
    return when (other) {
      !is Squirrel -> false
      else -> other.name == name && other.tree == tree
    }
  }
}