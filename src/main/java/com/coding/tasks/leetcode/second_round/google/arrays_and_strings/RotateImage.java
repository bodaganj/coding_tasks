package com.coding.tasks.leetcode.second_round.google.arrays_and_strings;

import java.util.Arrays;

public class RotateImage {

   public static void main(String[] args) {
      int[][] arr = new int[][]{
         {1, 2, 3,},
         {4, 5, 6,},
         {7, 8, 9}
      };
      System.out.println(Arrays.deepToString(arr));
      rotate(arr);
      System.out.println(Arrays.deepToString(arr));
   }

   private static void rotate(int[][] matrix) {
      int length = matrix.length;
      for (int i = 0; i < (length + 1) / 2; i++) {
         for (int j = 0; j < length / 2; j++) {
            int tmp = matrix[length - 1 - j][i];
            matrix[length - 1 - j][i] = matrix[length - 1 - i][length - 1 - j];
            matrix[length - 1 - i][length - 1 - j] = matrix[j][length - 1 - i];
            matrix[j][length - 1 - i] = matrix[i][j];
            matrix[i][j] = tmp;
         }
      }
   }
}
