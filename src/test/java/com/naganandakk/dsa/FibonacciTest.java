package com.naganandakk.dsa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FibonacciTest {

  @ParameterizedTest
  @MethodSource("fibonacciTestInputOutputProvider")
  void testRecursiveFibonacci(int input, int expected) {
    Assertions.assertEquals(expected, Fibonacci.recursive(input));
  }

  @Test
  void shouldThrowExceptionWHenFibonacciRecursiveIsCalledWithNegativeNUmber() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      Fibonacci.recursive(-1);
    });
  }


  private static Stream<Arguments> fibonacciTestInputOutputProvider() {
    return Stream.of(
        Arguments.of(0, 0),
        Arguments.of(1, 1),
        Arguments.of(2, 1),
        Arguments.of(3, 2),
        Arguments.of(4, 3),
        Arguments.of(5, 5),
        Arguments.of(6, 8),
        Arguments.of(7, 13),
        Arguments.of(8, 21)
    );
  }
}