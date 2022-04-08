package com.coding.tasks.leetcode.first_round.top_interview_questions.medium.sorting_and_searching;

public class Search2DMatrix2 {

   public static void main(String[] args) {
      System.out.println(searchMatrix(new int[][]{{5}}, 5));

      System.out.println(searchMatrix(new int[][]{
         {1, 4, 7, 11, 15},
         {2, 5, 8, 12, 19},
         {3, 6, 9, 16, 22},
         {10, 13, 14, 17, 24},
         {18, 21, 23, 26, 30}
      }, 5));

      System.out.println(searchMatrix(new int[][]{
         {1, 4, 7, 11, 15},
         {2, 5, 8, 12, 19},
         {3, 6, 9, 16, 22},
         {10, 13, 14, 17, 24},
         {18, 21, 23, 26, 30}
      }, 20));
   }

   private static boolean searchMatrix(int[][] matrix, int target) {
      // find in each column where matrix[0][i] < target
      for (int i = 0; i < matrix[0].length; i++) {
         if (matrix[0][i] <= target && findInColumn(matrix, i, target)) {
            return true;
         }
      }

      // find in each raw where matrix[i][0] < target
      for (int i = 0; i < matrix.length; i++) {
         if (matrix[i][0] <= target && findInRaw(matrix, i, target)) {
            return true;
         }
      }

      return false;
   }

   private static boolean findInColumn(int[][] matrix, int columnIndex, int target) {
      int start = 0;
      int end = matrix.length - 1;

      while (start <= end) {
         int middle = start + (end - start) / 2;

         if (matrix[middle][columnIndex] == target) {
            return true;
         } else if (matrix[middle][columnIndex] > target) {
            end = middle - 1;
         } else {
            start = middle + 1;
         }
      }

      return false;
   }

   private static boolean findInRaw(int[][] matrix, int rawIndex, int target) {
      int start = 0;
      int end = matrix[0].length - 1;

      while (start <= end) {
         int middle = start + (end - start) / 2;

         if (matrix[rawIndex][middle] == target) {
            return true;
         } else if (matrix[rawIndex][middle] > target) {
            end = middle - 1;
         } else {
            start = middle + 1;
         }
      }

      return false;
   }
}
