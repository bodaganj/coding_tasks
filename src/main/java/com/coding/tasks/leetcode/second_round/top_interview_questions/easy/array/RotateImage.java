package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.array;

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
      int length = matrix.length;
      int columnShift = 0;
      for (int i = 0; i < length / 2; i++) {
         for (int j = columnShift; j < length - columnShift - 1; j++) {
            int tmp = matrix[i][j];
            matrix[i][j] = matrix[length - j - 1][i];
            matrix[length - j - 1][i] = matrix[length - 1 - i][length - 1 - j];
            matrix[length - 1 - i][length - 1 - j] = matrix[j][length - 1 - i];
            matrix[j][length - 1 - i] = tmp;
         }
         columnShift++;
      }
   }
}
