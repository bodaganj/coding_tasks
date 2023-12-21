package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.array.and.string;

import java.util.Arrays;

public class SetMatrixZeroes {

   public void setZeroes(int[][] matrix) {
      boolean isZeroRow = false;
      for (int i = 0; i < matrix.length; i++) {
         for (int j = 0; j < matrix[i].length; j++) {
            if (matrix[i][j] == 0) {
               if (i == 0) {
                  isZeroRow = true;
               } else {
                  matrix[0][j] = 0;
                  matrix[i][0] = 0;
               }
            }
         }
      }

      for (int i = 1; i < matrix.length; i++) {
         if (matrix[i][0] == 0) {
            Arrays.fill(matrix[i], 0);
         }
      }

      for (int j = 0; j < matrix[0].length; j++) {
         if (matrix[0][j] == 0) {
            for (int i = 0; i < matrix.length; i++) {
               matrix[i][j] = 0;
            }
         }
      }

      if (isZeroRow) {
         Arrays.fill(matrix[0], 0);
      }
   }
}
