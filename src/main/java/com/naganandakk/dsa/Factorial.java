package com.naganandakk.dsa;

public class Factorial {

  public static int recursive(int n) {
    if (n < 0) {
      throw new RuntimeException("Negative number is not allowed.");
    }

    if (n == 0) {
      return 1;
    }

    return n * recursive(n - 1);
  }
}
