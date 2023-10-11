package com.examples.testing.badextraprivatevariable.incorrect.java.extraprivatefield;

import com.examples.testing.badextraprivatevariable.Parent;
import edu.illinois.cs.cs125.questioner.lib.Incorrect;

@Incorrect("features")
public class Child extends Parent {
  private final String firstName;
  private final String lastName;

  public Child(String setFirstName, String setLastName) {
    super(setLastName);
    lastName = setLastName;
    firstName = setFirstName;
  }

  @Override
  public String toString() {
    return firstName + " " + lastName;
  }
}
