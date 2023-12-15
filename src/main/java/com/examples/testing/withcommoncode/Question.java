package com.examples.testing.withcommoncode;

import com.examples.testing.common.Value;
import edu.illinois.cs.cs125.questioner.lib.Correct;

/*
 * Test loading common code.
 */

@Correct(name = "With Common Code", version = "2023.12.0", author = "challen@illinois.edu")
public class Question {
  public static Value createValue(int value) {
    return new Value(value);
  }
}
