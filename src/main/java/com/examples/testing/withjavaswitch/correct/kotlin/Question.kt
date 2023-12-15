package com.examples.testing.withjavaswitch.correct.kotlin

import edu.illinois.cs.cs125.questioner.lib.AlsoCorrect

/*
 * Test feature check using Java 14 switch expression, Kotlin equivalent.
 */

@AlsoCorrect
class Question {
  fun fromDay(day: Int): String = when (day) {
    0 -> "Monday"
    1 -> "Tuesday"
    2 -> "Wednesday"
    3 -> "Thursday"
    4 -> "Friday"
    5 -> "Saturday"
    6 -> "Sunday"
    else -> throw IllegalArgumentException()
  }
}