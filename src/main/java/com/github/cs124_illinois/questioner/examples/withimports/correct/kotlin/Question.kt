@file:AlsoCorrect

package com.github.cs124_illinois.questioner.examples.withimports.correct.kotlin

import edu.illinois.cs.cs125.questioner.lib.AlsoCorrect
import java.util.Arrays

/*
 * Test Kotlin top-level method with import statements.
 */

@Suppress("ReplaceJavaStaticMethodWithKotlinAnalog")
fun max(first: Int, second: Int): List<Int> {
  return Arrays.asList(first, second)
}