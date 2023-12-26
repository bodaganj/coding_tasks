package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.sorting.and.searching;

public class Search2DMatrixII {

   public static void main(String[] args) {
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

      System.out.println(searchMatrix(new int[][]{
         {1, 2, 3, 4, 5},
         {6, 7, 8, 9, 10},
         {11, 12, 13, 14, 15},
         {16, 17, 18, 19, 20},
         {21, 22, 23, 24, 25}
      }, 5));
   }

   public static boolean searchMatrix(int[][] matrix, int target) {
      int rl = 0;
      int rr = matrix.length - 1;
      int cl = 0;
      int cr = matrix[0].length - 1;

      return rec(matrix, target, rl, rr, cl, cr);
   }

   public static boolean rec(int[][] matrix, int target, int rl, int rr, int cl, int cr) {
      if (rl <= rr && cl <= cr) {
         int midc = cl + (cr - cl) / 2;
         int midr = rl + (rr - rl) / 2;

         if (matrix[midr][midc] == target) {
            return true;
         } else if (matrix[midr][midc] > target) {
            return rec(matrix, target, rl, midr - 1, cl, midc - 1) ||
               rec(matrix, target, midr, rr, cl, midc - 1) ||
               rec(matrix, target, rl, midr - 1, midc, cr);
         } else {
            return rec(matrix, target, midr + 1, rr, cl, midc) ||
               rec(matrix, target, midr + 1, rr, midc + 1, cr) ||
               rec(matrix, target, rl, midr, midc + 1, cr);
         }
      }
      return false;
   }
}
