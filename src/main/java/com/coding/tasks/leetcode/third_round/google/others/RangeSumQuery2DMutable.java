package com.coding.tasks.leetcode.third_round.google.others;

public class RangeSumQuery2DMutable {

   public static void main(String[] args) {
      NumMatrix numMatrix = new NumMatrix(new int[][]{
         {3, 0, 1, 4, 2},
         {5, 6, 3, 2, 1},
         {1, 2, 0, 1, 5},
         {4, 1, 0, 1, 7},
         {1, 0, 3, 0, 5}
      });
      System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
      numMatrix.update(3, 2, 2);
      System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
   }

   static class NumMatrix {

      private int[][] matrix;
      private int[][] sum;

      public NumMatrix(int[][] matrix) {
         this.matrix = matrix;
         this.sum = new int[matrix.length][matrix[0].length];
         for (int i = 0; i < matrix.length; i++) {
            int currSum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
               currSum += matrix[i][j];
               sum[i][j] = currSum;
            }
         }
      }

      public void update(int row, int col, int val) {
         this.matrix[row][col] = val;
         int currSum = col > 0 ? sum[row][col - 1] : 0;
         for (int j = col; j < sum[row].length; j++) {
            currSum += matrix[row][j];
            sum[row][j] = currSum;
         }
      }

      public int sumRegion(int row1, int col1, int row2, int col2) {
         int ans = 0;
         for (int i = row1; i <= row2; i++) {
            ans += sum[i][col2];
            ans -= col1 > 0 ? sum[i][col1 - 1] : 0;
         }
         return ans;
      }
   }
}
