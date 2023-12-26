package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.dynamic.programming;

import java.util.Arrays;

public class UniquePaths {

   public static void main(String[] args) {
      System.out.println(uniquePaths(3, 7));
   }

   public static int uniquePaths(int m, int n) {
      if (m == 1 || n == 1) {
         return 1;
      }

      int[] arr = new int[n];
      Arrays.fill(arr, 1);

      for (int i = 1; i < m; i++) {
         for (int j = 1; j < n; j++) {
            arr[j] = arr[j] + arr[j - 1];
         }
      }
      return arr[n - 1];
   }

   public static int uniquePaths1(int m, int n) {
      if (m == 1 || n == 1) {
         return 1;
      }
      int[][] memo = new int[m][n];
      rec(m, n, 0, 0, memo);
      return memo[0][0];
   }

   private static int rec(int m, int n, int i, int j, int[][] memo) {
      if (i == m - 1 && j == n - 1) {
         return 1;
      }
      if (i >= m || j >= n) {
         return 0;
      } else {
         if (memo[i][j] == 0) {
            memo[i][j] = rec(m, n, i + 1, j, memo) + rec(m, n, i, j + 1, memo);
         }
         return memo[i][j];
      }
   }
}
