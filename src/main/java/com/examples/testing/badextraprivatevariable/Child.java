package com.examples.testing.badextraprivatevariable;

import edu.illinois.cs.cs125.jeed.core.FeatureName;
import edu.illinois.cs.cs125.jeed.core.Features;
import edu.illinois.cs.cs125.jenisol.core.Both;
import edu.illinois.cs.cs125.questioner.lib.CheckFeatures;
import edu.illinois.cs.cs125.questioner.lib.Correct;
import edu.illinois.cs.cs125.questioner.lib.FeatureCheckException;
import java.util.ArrayList;
import java.util.List;

/*
 * Test bad use of superclass method.
 */

@Correct(
    name = "Bad Extra Private Variable",
    version = "2023.10.0",
    author = "challen@illinois.edu")
public class Child extends Parent {
  private final String firstName;

  public Child(String setFirstName, String setLastName) {
    super(setLastName);
    firstName = setFirstName;
  }

  @Override
  public String toString() {
    return firstName + " " + getLastName();
  }

  @CheckFeatures
  private static List<String> checkFeatures(Features solution, Features submission) {
    int solutionVariableCount = solution.getFeatureMap().getOrDefault(FeatureName.CLASS_FIELD, 0);
    int submissionVariableCount =
        submission.getFeatureMap().getOrDefault(FeatureName.CLASS_FIELD, 0);
    if (submissionVariableCount > solutionVariableCount) {
      throw new FeatureCheckException("Submission declares too many fields");
    }
    return new ArrayList<>();
  }

  @Both
  private static String checkName(Parent parent) {
    return parent.getLastName();
  }
}
