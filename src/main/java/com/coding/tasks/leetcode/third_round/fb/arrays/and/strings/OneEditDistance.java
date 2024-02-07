package com.coding.tasks.leetcode.third_round.fb.arrays.and.strings;

public class OneEditDistance {

   public static void main(String[] args) {
      System.out.println(isOneEditDistance("a", "A"));
   }

   public static boolean isOneEditDistance(String s, String t) {
      int[][] dp = new int[s.length() + 1][t.length() + 1];
      for (int i = 0; i < dp.length; i++) {
         dp[i][0] = i;
      }
      for (int i = 0; i < dp[0].length; i++) {
         dp[0][i] = i;
      }

      for (int i = 1; i < dp.length; i++) {
         for (int j = 1; j < dp[i].length; j++) {
            if (s.charAt(i - 1) == t.charAt(j - 1)) {
               dp[i][j] = dp[i - 1][j - 1];
            } else {
               dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
            }
         }
      }

      return dp[s.length()][t.length()] == 1;
   }
}
