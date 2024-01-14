package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.design;

public class RangeSumQuery2DMutable {

   public static void main(String[] args) {
//      NumMatrix numMatrix = new NumMatrix(new int[][]{
//         {1, 2, 3, 4},
//         {5, 6, 7, 8},
//         {9, 10, 11, 12}
//      });
//      System.out.println(numMatrix.sumRegion(1, 1, 2, 3));
//      numMatrix.update(1, 1, 10);
//      System.out.println(numMatrix.sumRegion(1, 1, 2, 3));
   }

   static class NumMatrix {

      private int[][] colSums;
      private int[][] matrix;

      public NumMatrix(int[][] matrix) {
      }

      //time complexity for the worst case scenario: O(m)
      public void update(int row, int col, int val) {
      }

      //time complexity for the worst case scenario: O(n)
//      public int sumRegion(int row1, int col1, int row2, int col2) {
//      }
   }
}
