package com.naganandakk.dsa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class FactorialTest {

  @ParameterizedTest
  @MethodSource("factorialTestInputOutputProvider")
  void testRecursiveFactorial(int input, int expected) {
    Assertions.assertEquals(expected, Factorial.recursive(input));
  }

  @Test
  void shouldThrowExceptionWHenFactorialRecursiveIsCalledWithNegativeNUmber() {
    Assertions.assertThrows(RuntimeException.class, () -> {
      Factorial.recursive(-1);
    });
  }

  private static Stream<Arguments> factorialTestInputOutputProvider() {
    return Stream.of(
        Arguments.of(0, 1),
        Arguments.of(1, 1),
        Arguments.of(2, 2),
        Arguments.of(3, 6),
        Arguments.of(4, 24),
        Arguments.of(5, 120)
    );
  }
}