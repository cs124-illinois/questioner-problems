package com.examples.testing.badextraprivatevariable.correct.kotlin

import com.examples.testing.badextraprivatevariable.Parent
import edu.illinois.cs.cs125.questioner.lib.AlsoCorrect

/*
 * Test bad use of superclass method.
 */

@AlsoCorrect
class Child(private val firstName: String?, lastName: String?) : Parent(lastName) {
  override fun toString() = "$firstName $lastName"
}