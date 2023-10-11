package com.examples.testing.badkotlingettersetter.incorrect.kotlin.badgetter

import edu.illinois.cs.cs125.questioner.lib.Incorrect

@Suppress("RedundantGetter")
@Incorrect("features")
class Example(name: String?) {
  var name = name
    get() {
      return field
    }
}