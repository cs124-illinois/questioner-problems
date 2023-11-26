package com.examples.testing.badkotlingettersetter;

import edu.illinois.cs.cs125.jeed.core.FeatureName;
import edu.illinois.cs.cs125.jeed.core.Features;
import edu.illinois.cs.cs125.questioner.lib.CheckFeatures;
import edu.illinois.cs.cs125.questioner.lib.Correct;
import edu.illinois.cs.cs125.questioner.lib.FeatureCheckException;
import edu.illinois.cs.cs125.questioner.lib.Language;
import java.util.ArrayList;
import java.util.List;

/*
 * Test to ensure that we can detect unnecessary Kotlin setter or getter overrides.
 */

@Correct(
    name = "Test Bad Kotlin Getter Setter",
    version = "2023.10.0",
    author = "challen@illinois.edu")
public class Example {
  private String name;

  public Example(String setName) {
    name = setName;
  }

  public String getName() {
    return name;
  }

  public void setName(String setName) {
    name = setName;
  }

  @CheckFeatures
  private static List<String> checkFeatures(
      Language language, Features solution, Features submission) {
    if (language == Language.kotlin) {
      if (submission.getFeatureMap().containsKey(FeatureName.GETTER)) {
        throw new FeatureCheckException("Solution overrides a getter unnecessarily");
      }
      if (submission.getFeatureMap().containsKey(FeatureName.SETTER)) {
        throw new FeatureCheckException("Solution overrides a setter unnecessarily");
      }
    }
    return new ArrayList<>();
  }
}
