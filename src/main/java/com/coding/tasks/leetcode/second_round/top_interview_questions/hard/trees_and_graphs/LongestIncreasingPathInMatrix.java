package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.trees_and_graphs;

public class LongestIncreasingPathInMatrix {

   private static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

   public static void main(String[] args) {
      int[][] arr1 = new int[][]{
         {9, 9, 4},
         {6, 6, 8},
         {2, 1, 1}
      };
      int[][] arr2 = new int[][]{
         {7, 8, 9},
         {9, 7, 6},
         {7, 2, 3}
      };

      System.out.println(longestIncreasingPath(arr1));
//      System.out.println(longestIncreasingPath(arr2));
//      System.out.println(longestIncreasingPath(new int[][]{{1}}));
   }

   private static int longestIncreasingPath(int[][] matrix) {
      int[][] dp = new int[matrix.length][matrix[0].length];
      for (int i = 0; i < matrix.length; i++) {
         for (int j = 0; j < matrix[0].length; j++) {
            dfs(matrix, i, j, dp, -1);
         }
      }

      int max = 1;
      for (int[] ints : dp) {
         for (int j = 0; j < dp[0].length; j++) {
            max = Math.max(max, ints[j]);
         }
      }
      return max;
   }

   private static int dfs(int[][] matrix, int i, int j, int[][] dp, int prev) {
      if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length && prev < matrix[i][j]) {
         if (dp[i][j] < 1) {
            int maxNeighbourPath = 0;
            for (int[] dir : dirs) {
               maxNeighbourPath = Math.max(maxNeighbourPath, dfs(matrix, i + dir[0], j + dir[1], dp, matrix[i][j]));
            }

            dp[i][j] = 1 + maxNeighbourPath;
         }
         return dp[i][j];
      } else {
         return 0;
      }
   }
}
