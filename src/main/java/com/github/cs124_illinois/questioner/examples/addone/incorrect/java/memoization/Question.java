package com.github.cs124_illinois.questioner.examples.addone.incorrect.java.memoization;

import edu.illinois.cs.cs125.questioner.lib.Incorrect;

@Incorrect(reason = "memoization")
public class Question {
  int addOne(int value) {
    if (value == 1) {
      return 2;
    } else if (value == 2) {
      return 3;
    } else if (value == 3) {
      return 4;
    } else if (value == 4) {
      return 5;
    } else if (value == 5) {
      return 6;
    } else if (value == 6) {
      return 7;
    } else if (value == 7) {
      return 8;
    } else if (value == 8) {
      return 9;
    } else if (value == 9) {
      return 10;
    } else if (value == 10) {
      return 11;
    } else if (value == 11) {
      return 12;
    } else if (value == 12) {
      return 13;
    } else if (value == 13) {
      return 14;
    } else if (value == 14) {
      return 15;
    } else if (value == 15) {
      return 16;
    } else if (value == 16) {
      return 17;
    } else {
      return value + 1;
    }
  }
}
