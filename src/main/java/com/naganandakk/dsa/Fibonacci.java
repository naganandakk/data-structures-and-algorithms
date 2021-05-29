package com.naganandakk.dsa;

public class Fibonacci {

  public static int recursive(int n) {
    if (n < 0) {
      throw new RuntimeException("Negative number is not allowed.");
    }

    if (n == 0) {
      return 0;
    }

    if (n == 1) {
      return 1;
    }

    return recursive(n - 1) + recursive(n - 2);
  }
}
