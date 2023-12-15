package com.examples.testing.common;

import java.util.Objects;

public class Value {
  private int value;

  public Value(int setValue) {
    value = setValue;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Value value1 = (Value) o;
    return value == value1.value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
