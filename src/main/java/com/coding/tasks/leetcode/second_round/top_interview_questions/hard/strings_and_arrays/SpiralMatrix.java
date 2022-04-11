package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.strings_and_arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

   private static int[][] direction = new int[][]{
      {0, 1}, // right
      {1, 0}, // down
      {0, -1}, // left
      {-1, 0} // up
   };

   public static void main(String[] args) {
      System.out.println(spiralOrder(new int[][]{
         {1, 2, 3, 4},
         {5, 6, 7, 8},
         {9, 10, 11, 12},
         {13, 14, 15, 16}
      }));

      System.out.println(spiralOrder(new int[][]{{3}, {2}}));
   }

   private static List<Integer> spiralOrder(int[][] matrix) {
      List<Integer> ans = new ArrayList<>();
      dfs(matrix, 0, 0, new int[]{0, 1}, ans);
      return ans;
   }

   private static void dfs(int[][] matrix, int i, int j, int[] defaultDirection, List<Integer> ans) {
      if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length && matrix[i][j] != -1000) {
         ans.add(matrix[i][j]);
         matrix[i][j] = -1000;

         int potentialI = i + defaultDirection[0];
         int potentialJ = j + defaultDirection[1];

         if (potentialI >= 0 && potentialI < matrix.length && potentialJ >= 0 && potentialJ < matrix[0].length
            && matrix[potentialI][potentialJ] != -1000) {
            dfs(matrix, potentialI, potentialJ, defaultDirection, ans);
         } else {
            for (int[] ints : direction) {
               dfs(matrix, i + ints[0], j + ints[1], ints, ans);
            }
         }
      }
   }
}
