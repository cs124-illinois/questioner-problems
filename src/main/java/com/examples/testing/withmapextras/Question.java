package com.examples.testing.withmapextras;

import edu.illinois.cs.cs125.jenisol.core.NotNull;
import edu.illinois.cs.cs125.questioner.lib.Correct;
import edu.illinois.cs.cs125.questioner.lib.Wrap;
import java.util.Map;

/*
 * Test whether Map automatic whitelisting works.
 * Note that tests are in Questioner.
 */

@Correct(name = "With Map Extras", author = "challen@illinois.edu", version = "2023.9.0")
@Wrap
public class Question {
  int mapSize(@NotNull Map<String, Integer> map) {
    return map.size();
  }
}
