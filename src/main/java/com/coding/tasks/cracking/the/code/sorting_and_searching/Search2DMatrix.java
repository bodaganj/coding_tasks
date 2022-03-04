package com.coding.tasks.cracking.the.code.sorting_and_searching;

public class Search2DMatrix {

   public static void main(String[] args) {
      System.out.println(searchMatrix(new int[][]{{1}}, 2));
      System.out.println(searchMatrix(new int[][]{{1, 1}}, 2));
      System.out.println(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
      System.out.println(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13));
   }

   private static boolean searchMatrix(int[][] matrix, int target) {
      // 1. Find the row where target might be present (search for last column)
      int rowWithTarget = getRowWithStatic(matrix, target);
      if (rowWithTarget == -1) {
         return false;
      }

      // 2. Binary search within the row
      int left = 0;
      int right = matrix[0].length - 1;

      while (left <= right) {
         int middle = left + (right - left) / 2;

         if (matrix[rowWithTarget][middle] == target) {
            return true;
         } else if (matrix[rowWithTarget][middle] > target) {
            right = middle - 1;
         } else {
            left = middle + 1;
         }
      }

      return false;
   }

   private static int getRowWithStatic(int[][] matrix, int target) {
      int rows = matrix.length - 1;
      int columns = matrix[0].length - 1;

      int top = 0;
      int bottom = rows;
      int rowWithTarget = -1;

      while (top <= bottom && top >= 0) {
         int middle = top + (bottom - top) / 2;

         if (matrix[middle][columns] == target) {
            return middle;
         } else if (matrix[middle][columns] < target) {
            if (middle == rows) {
               return -1;
            } else if (matrix[middle + 1][columns] > target) {
               return middle + 1;
            } else {
               top = middle + 1;
            }
         } else {
            if (middle == 0) {
               return middle;
            } else if (matrix[middle - 1][columns] < target) {
               return middle;
            } else {
               bottom = middle - 1;
            }
         }
      }
      return rowWithTarget;
   }
}
