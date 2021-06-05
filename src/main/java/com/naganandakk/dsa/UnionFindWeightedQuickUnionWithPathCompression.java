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

public class UnionFindWeightedQuickUnionWithPathCompression {
  private final int[] id;
  private final int[] size;

  public UnionFindWeightedQuickUnionWithPathCompression(int n) {
    if (n < 2) {
      throw new IllegalArgumentException("n should be >= 2");
    }

    id = new int[n];
    size = new int[n];
    for (int i = 0; i < n; i++) {
      id[i] = i;
      size[i] = 1;
    }
  }

  public boolean connected(int p, int q) {
    checkRange(p, q);

    return root(p) == root(q);
  }

  public void union(int p, int q) {
    checkRange(p, q);

    if (p != q) {
      int rp = root(p);
      int rq = root(q);

      if (rp == rq) return;

      if (size[rp] < size[rq]) {
        id[rp] = rq;
        size[rq] += size[rp];
      } else {
        id[rq] = rp;
        size[rp] += size[rq];
      }
    }
  }

  private int root(int i) {
    while (i != id[i]) {
      id[i] = id[id[i]];
      i = id[i];
    }

    return i;
  }
  private void checkRange(int p, int q) {
    if ((p < 0) || (p >= id.length) || (q < 0) || (q >= id.length)) {
      throw new IllegalArgumentException("Input not in range");
    }
  }
}
