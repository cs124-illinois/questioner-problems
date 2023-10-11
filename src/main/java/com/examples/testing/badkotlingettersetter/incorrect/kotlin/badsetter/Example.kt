package com.examples.testing.badkotlingettersetter.incorrect.kotlin.badsetter

import edu.illinois.cs.cs125.questioner.lib.Incorrect

@Suppress("RedundantSetter")
@Incorrect("features")
class Example(name: String?) {
  var name = name
    set(value) {
      field = value
    }
}