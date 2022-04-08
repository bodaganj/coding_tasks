package com.coding.tasks.leetcode.first_round.google.other;

public class RangeSumQuery2DMutable {

   public static void main(String[] args) {

   }

   static class NumMatrix {

      private int[][] m;

      public NumMatrix(int[][] matrix) {
         this.m = matrix;
      }

      public void update(int row, int col, int val) {
         this.m[row][col] = val;
      }

      public int sumRegion(int row1, int col1, int row2, int col2) {
         int sum = 0;

         for (int x = row1; x <= row2; x++) {
            for (int y = col1; y <= col2; y++) {
               sum += m[x][y];
            }
         }

         return sum;
      }
   }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
}
