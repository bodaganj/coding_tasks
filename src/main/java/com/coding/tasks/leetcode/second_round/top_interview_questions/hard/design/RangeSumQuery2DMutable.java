package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.design;

public class RangeSumQuery2DMutable {

   public static void main(String[] args) {

      int[][] arr = new int[][]{
         {3, 0, 1, 4, 2},
         {5, 6, 3, 2, 1},
         {1, 2, 0, 1, 5},
         {4, 1, 0, 1, 7},
         {1, 0, 3, 0, 5},
      };
      NumMatrix o = new NumMatrix(arr);
      System.out.println(o.sumRegion(2, 1, 4, 3));
      o.update(3, 2, 2);
      System.out.println(o.sumRegion(2, 1, 4, 3));
   }

   /**
    * Your NumMatrix object will be instantiated and called as such:
    * NumMatrix obj = new NumMatrix(matrix);
    * obj.update(row,col,val);
    * int param_2 = obj.sumRegion(row1,col1,row2,col2);
    */
   static class NumMatrix {

      private int[][] matrix;
      private int[][] matrixSum;

      public NumMatrix(int[][] matrix) {
         this.matrix = matrix;
         matrixSum = new int[matrix.length][matrix[0].length];
         createSumMatrix();
      }

      public void update(int row, int col, int val) {
         int dif = val - matrix[row][col];
         if (dif != 0) {
            matrix[row][col] = val;
            fixSum(row, col, dif);
         }
      }

      public int sumRegion(int row1, int col1, int row2, int col2) {
         int leftPart = col1 - 1 >= 0 ? matrixSum[row2][col1 - 1] : 0;
         int topPart = row1 - 1 >= 0 ? matrixSum[row1 - 1][col2] : 0;
         int missing = col1 - 1 >= 0 && row1 - 1 >= 0 ? matrixSum[row1 - 1][col1 - 1] : 0;
         return matrixSum[row2][col2] - leftPart - topPart + missing;
      }

      private void fixSum(int row, int col, int dif) {
         for (int i = row; i < matrixSum.length; i++) {
            for (int j = col; j < matrixSum[0].length; j++) {
               matrixSum[i][j] += dif;
            }
         }
      }

      private void createSumMatrix() {
         for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
               int top = i - 1 >= 0 ? matrixSum[i - 1][j] : 0;
               int left = j - 1 >= 0 ? matrixSum[i][j - 1] : 0;
               int diag = i - 1 >= 0 && j - 1 >= 0 ? matrixSum[i - 1][j - 1] : 0;
               matrixSum[i][j] = top + left - diag + matrix[i][j];
            }
         }
      }
   }
}
