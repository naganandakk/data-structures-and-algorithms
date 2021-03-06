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

import com.naganandakk.dsa.exceptions.IllegalArgumentException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UnionFindQuickFindTest {

  @ParameterizedTest
  @ValueSource(ints = {-1, 0, 1})
  void shouldNotAcceptLessThanTwoItems(int n) {
    Assertions.assertThrows(IllegalArgumentException.class, () -> new UnionFindQuickFind(n));
  }

  @Test
  void shouldThrowExceptionWhenConnectedIsCalledWithOutOfRangeValues() {
    int n = 10;
    UnionFindQuickFind unionFindQuickFind = new UnionFindQuickFind(n);
    Assertions.assertThrows(IllegalArgumentException.class, () -> unionFindQuickFind.connected(-1, 0));
    Assertions.assertThrows(IllegalArgumentException.class, () -> unionFindQuickFind.connected(0, -1));
    Assertions.assertThrows(IllegalArgumentException.class, () -> unionFindQuickFind.connected(n, 0));
    Assertions.assertThrows(IllegalArgumentException.class, () -> unionFindQuickFind.connected(0, n));
  }

  @Test
  void shouldThrowExceptionWhenUnionIsCalledWithOutOfRangeValues() {
    int n = 10;
    UnionFindQuickFind unionFindQuickFind = new UnionFindQuickFind(n);
    Assertions.assertThrows(IllegalArgumentException.class, () -> unionFindQuickFind.union(-1, 0));
    Assertions.assertThrows(IllegalArgumentException.class, () -> unionFindQuickFind.union(0, -1));
    Assertions.assertThrows(IllegalArgumentException.class, () -> unionFindQuickFind.union(n, 0));
    Assertions.assertThrows(IllegalArgumentException.class, () -> unionFindQuickFind.union(0, n));
  }

  @Test
  void shouldReturnConnectedForReflectiveValues() {
    int n = 10;
    UnionFindQuickFind unionFindQuickFind = new UnionFindQuickFind(n);
    for (int i = 0; i < n; i++) {
      Assertions.assertTrue(unionFindQuickFind.connected(i, i));
    }
  }

  @Test
  void shouldReturnConnectedForSymmetricValues() {
    int n = 10;
    UnionFindQuickFind unionFindQuickFind = new UnionFindQuickFind(n);
    for (int i = 0; i < n; i += 2) {
      unionFindQuickFind.union(i, i + 1);
      Assertions.assertTrue(unionFindQuickFind.connected(i, i + 1));
    }
  }

  @Test
  void shouldReturnConnectedForTransitiveValues() {
    int n = 10000;
    UnionFindQuickFind unionFindQuickFind = new UnionFindQuickFind(n);
    for (int i = 0; i < n - 1; i ++) {
      unionFindQuickFind.union(i, i + 1);
    }
    Assertions.assertTrue(unionFindQuickFind.connected(0, 2));
    Assertions.assertTrue(unionFindQuickFind.connected(0, 3));
    Assertions.assertTrue(unionFindQuickFind.connected(1, 3));
  }

  @Test
  void shouldReturnNotConnectedForNotConnectedValues() {
    int n = 10;
    UnionFindQuickFind unionFindQuickFind = new UnionFindQuickFind(n);
    for (int i = 0; i < n - 1; i++) {
      Assertions.assertFalse(unionFindQuickFind.connected(i, i + 1));
    }
  }
}