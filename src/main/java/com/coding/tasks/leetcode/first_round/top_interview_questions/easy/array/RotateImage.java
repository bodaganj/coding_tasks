package com.coding.tasks.leetcode.first_round.top_interview_questions.easy.array;

import java.util.Arrays;

public class RotateImage {

   public static void main(String[] args) {
      int[][] array = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

      System.out.println("Before rotation");
      for (int[] ints : array) {
         System.out.println(Arrays.toString(ints));
      }

      System.out.println("After rotation");
      rotateMatrix(array);
      for (int[] ints : array) {
         System.out.println(Arrays.toString(ints));
      }
   }

   private static void rotateMatrix(int[][] matrix) {
      int n = matrix.length;
      for (int i = 0; i < n / 2; i++) {
         for (int j = i; j < n - 1 - i; j++) {
            int tmp = matrix[i][j];
            matrix[i][j] = matrix[n - 1 - j][i];
            matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
            matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
            matrix[j][n - 1 - i] = tmp;
         }
      }
   }
}
