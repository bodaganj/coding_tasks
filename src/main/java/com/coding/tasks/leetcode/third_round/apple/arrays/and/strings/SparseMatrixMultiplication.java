package com.coding.tasks.leetcode.third_round.apple.arrays.and.strings;

import java.util.Arrays;

public class SparseMatrixMultiplication {

  public static void main(String[] args) {
    System.out.println(Arrays.deepToString(multiply(new int[][]{
            {1, 0, 0},
            {-1, 0, 3}
        },
        new int[][]{
            {7, 0, 0},
            {0, 0, 0},
            {0, 0, 1}
        })));
  }

  public static int[][] multiply(int[][] mat1, int[][] mat2) {
    int[][] ans = new int[mat1.length][mat2[0].length];
    for (int i = 0; i < ans.length; i++) {
      for (int j = 0; j < ans[0].length; j++) {
        int sum = 0;
        for (int x = 0; x < mat1[0].length; x++) {
          sum += mat1[i][x] * mat2[x][j];
        }
        ans[i][j] = sum;
      }
    }
    return ans;
  }
}
