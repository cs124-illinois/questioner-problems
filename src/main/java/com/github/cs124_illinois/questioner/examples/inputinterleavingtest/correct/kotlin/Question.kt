@file:AlsoCorrect

package com.github.cs124_illinois.questioner.examples.inputinterleavingtest.correct.kotlin

import edu.illinois.cs.cs125.questioner.lib.AlsoCorrect
import java.util.Scanner

/*
 * Testing STDIN generation and interleaving. In Kotlin!
 */

fun echo() {
  println("Hello!")
  val scanner = Scanner(System.`in`)
  val first = scanner.nextLine()
  println("First: $first")
  val second = scanner.nextLine()
  println("Second: $second")
}