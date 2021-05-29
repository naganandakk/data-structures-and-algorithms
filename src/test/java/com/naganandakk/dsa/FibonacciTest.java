/*
 * Copyright (c) 2021.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the
 * Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NON-INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

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