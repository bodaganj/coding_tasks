package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.array_and_strings;

import java.util.Arrays;

public class SetMatrixZeroes {

   public static void main(String[] args) {
      int[][] arr1 = new int[][]{
         {1, 1, 1, 1, 1},
         {1, 0, 1, 1, 1},
         {1, 1, 1, 0, 1}
      };
      setZeroes(arr1);
      System.out.println(Arrays.deepToString(arr1));

      int[][] arr2 = new int[][]{
         {0, 1, 1, 0},
         {1, 1, 1, 1},
         {1, 1, 1, 1}
      };
      setZeroes(arr2);
      System.out.println(Arrays.deepToString(arr2));

      int[][] arr3 = new int[][]{
         {1, 1, 1, 1},
         {1, 0, 1, 1},
         {0, 1, 1, 1},
         {1, 1, 1, 0}
      };
      setZeroes(arr3);
      System.out.println(Arrays.deepToString(arr3));
   }

   private static void setZeroes(int[][] matrix) {
      int[] zero = findZero(matrix);
      if (zero.length != 0) {
         int row = zero[0];
         int column = zero[1];

         for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
               if (matrix[i][j] == 0) {
                  matrix[i][column] = 0;
                  matrix[row][j] = 0;
               }
            }
         }

         // set 0 to all rows/columns except the initial one
         for (int i = 0; i < matrix.length; i++) {
            if (i != row) {
               for (int j = 0; j < matrix[0].length; j++) {
                  if (j != column) {
                     if (matrix[row][j] == 0) {
                        matrix[i][j] = 0;
                     }
                     if (matrix[i][column] == 0) {
                        matrix[i][j] = 0;
                     }
                  }
               }
            }
         }

         // set 0 to initial one
         for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
         }
         for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
         }
      }
   }

   private static int[] findZero(int[][] matrix) {
      for (int i = 0; i < matrix.length; i++) {
         for (int j = 0; j < matrix[i].length; j++) {
            if (matrix[i][j] == 0) {
               return new int[]{i, j};
            }
         }
      }

      return new int[0];
   }
}
