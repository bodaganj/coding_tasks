package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.array;

import java.util.Arrays;

public class RotateImage {

   public static void main(String[] args) {
      int[][] array = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

      System.out.println("Before rotation");
      for (int[] ints : array) {
         System.out.println(Arrays.toString(ints));
      }

      System.out.println("After rotation");
      rotate(array);
      for (int[] ints : array) {
         System.out.println(Arrays.toString(ints));
      }
   }

   public static void rotate(int[][] matrix) {
      int length = matrix.length - 1;
      for (int i = 0; i <= length / 2; i++) {
         for (int j = i; j < length - i; j++) {
            int tmp = matrix[i][j];
            matrix[i][j] = matrix[length - j][i];
            matrix[length - j][i] = matrix[length - i][length - j];
            matrix[length - i][length - j] = matrix[j][length - i];
            matrix[j][length - i] = tmp;
         }
      }
   }
}
