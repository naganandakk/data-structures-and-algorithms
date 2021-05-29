package com.naganandakk.dsa;

public class Factorial {

  public static int recursive(int n) {
    if (n <= 0) {
      return 1;
    }

    return n * recursive(n - 1);
  }
}
