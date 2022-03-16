package com.coding.tasks.leetcode.top.interview.questions.hard.design;

public class RangeSumQuery2DMutable {

   /**
    * Your NumMatrix object will be instantiated and called as such:
    * NumMatrix obj = new NumMatrix(matrix);
    * obj.update(row,col,val);
    * int param_2 = obj.sumRegion(row1,col1,row2,col2);
    */
   static class NumMatrix {

      private int[][] matrix;

      public NumMatrix(int[][] matrix) {
         this.matrix = matrix;
      }

      public void update(int row, int col, int val) {
         this.matrix[row][col] = val;
      }

      public int sumRegion(int row1, int col1, int row2, int col2) {
         int sum = 0;
         for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
               sum += this.matrix[i][j];
            }
         }
         return sum;
      }
   }
}
