package com.examples.testing.badextraprivatevariable.incorrect.kotlin.extraprivatefield

import com.examples.testing.badextraprivatevariable.Parent
import edu.illinois.cs.cs125.questioner.lib.Incorrect

@Incorrect("features")
class Child(private val firstName: String?, private val lastName: String?) : Parent(lastName) {
  override fun toString() = "$firstName $lastName"
}