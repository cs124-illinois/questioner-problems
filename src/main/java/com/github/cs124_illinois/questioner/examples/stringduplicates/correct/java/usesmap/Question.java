package com.github.cs124_illinois.questioner.examples.stringduplicates.correct.java.usesmap;

import edu.illinois.cs.cs125.questioner.lib.AlsoCorrect;
import java.util.HashMap;
import java.util.Map;

@AlsoCorrect
public class Question {
  boolean detectDuplicates(String input) {
    Map<String, Boolean> values = new HashMap<>();
    for (String part : input.split(",")) {
      String current = part.trim();
      if (values.keySet().contains(current)) {
        return true;
      }
      values.put(current, true);
    }
    return false;
  }
}
