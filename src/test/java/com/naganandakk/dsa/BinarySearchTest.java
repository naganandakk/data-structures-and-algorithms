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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BinarySearchTest {

  @ParameterizedTest
  @MethodSource("binarySearchInputProvider")
  void testRecursiveBinarySearch(int[] input, int item, int expected) {
    Assertions.assertEquals(expected, BinarySearch.recursive(input, item));
  }

  private static Stream<Arguments> binarySearchInputProvider() {
    return Stream.of(
        Arguments.of(
            new int[]{0, 10, 20, 21, 30, 40, 50}, 21, 3
        ),
        Arguments.of(
            new int[]{0, 10, 20, 21, 30, 40, 50}, 0, 0
        ),
        Arguments.of(
            new int[]{0, 10, 20, 21, 30, 40, 50}, 50, 6
        ),
        Arguments.of(
            new int[]{0, 10, 20, 21, 30, 40, 50}, 28, -1
        ),
        Arguments.of(
            new int[]{0, 10, 20, 21, 30, 40, 50}, 100, -1
        ),
        Arguments.of(
            new int[]{0, 10, 20, 21, 30, 40, 50}, -10, -1
        )
    );
  }
}