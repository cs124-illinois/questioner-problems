package com.examples.testing.withjavaswitch.incorrect.java.withifelse;

import edu.illinois.cs.cs125.questioner.lib.Incorrect;

@Incorrect("features")
public class Question {
  String fromDay(int day) {
    if (day == 0) {
      return "Monday";
    } else if (day == 1) {
      return "Tuesday";
    } else if (day == 2) {
      return "Wednesday";
    } else if (day == 3) {
      return "Thursday";
    } else if (day == 4) {
      return "Friday";
    } else if (day == 5) {
      return "Saturday";
    } else if (day == 6) {
      return "Sunday";
    } else {
      throw new IllegalArgumentException();
    }
  }
}
