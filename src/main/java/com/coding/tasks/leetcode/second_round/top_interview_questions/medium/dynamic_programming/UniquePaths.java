package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.dynamic_programming;

import java.util.Arrays;

public class UniquePaths {

   private static int[][] dirs = new int[][]{{1, 0}, {0, 1}};

   public static void main(String[] args) {
      System.out.println(uniquePaths(3, 2));
      System.out.println(uniquePathsRec(3, 2));
      System.out.println(uniquePaths(3, 7));
      System.out.println(uniquePathsRec(3, 7));
      System.out.println(uniquePathsRec(1, 2));
   }

   // dp
   private static int uniquePaths(int m, int n) {
      int[][] dp = new int[m][n];
      Arrays.fill(dp[0], 1);
      for (int i = 0; i < m; i++) {
         dp[i][0] = 1;
      }

      for (int i = 1; i < m; i++) {
         for (int j = 1; j < n; j++) {
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
         }
      }
      return dp[m - 1][n - 1];
   }

   // recursion bottom up
   private static int uniquePathsRec(int m, int n) {
      if (m == 1 || n == 1) {
         return 1;
      }

      int[][] memo = new int[m + 1][n + 1];
      for (int i = 0; i < memo.length; i++) {
         for (int j = 0; j < memo[0].length; j++) {
            memo[i][j] = -1;
         }
      }
      return rec(m - 1, n, memo) + rec(m, n - 1, memo);
   }

   private static int rec(int m, int n, int[][] memo) {
      if (m == 1 || n == 1) {
         return 1;
      } else if (memo[m][n] > -1) {
         return memo[m][n];
      } else {
         memo[m][n] = rec(m - 1, n, memo) + rec(m, n - 1, memo);
         return memo[m][n];
      }
   }

   // recursion top down
//   private static int uniquePaths(int m, int n) {
//      int[][] memo = new int[m + 1][n + 1];
//      for (int i = 0; i < memo.length; i++) {
//         for (int j = 0; j < memo[0].length; j++) {
//            memo[i][j] = -1;
//         }
//      }
//
//      return dfs(List.of(1, 1), List.of(m, n), memo);
//   }
//
//   private static int dfs(List<Integer> current, List<Integer> finish, int[][] memo) {
//      if (current.equals(finish)) {
//         return 1;
//      } else if (memo[current.get(0)][current.get(1)] != -1) {
//         return memo[current.get(0)][current.get(1)];
//      } else {
//         int counter = 0;
//         for (int[] dir : dirs) {
//            int i = current.get(0) + dir[0];
//            int j = current.get(1) + dir[1];
//            List<Integer> potentialNextStep = List.of(i, j);
//
//            if (i >= 1 && i <= finish.get(0) && j >= 1 && j <= finish.get(1)) {
//               counter += dfs(potentialNextStep, finish, memo);
//            }
//         }
//         memo[current.get(0)][current.get(1)] = counter;
//         return memo[current.get(0)][current.get(1)];
//      }
//   }
}
