package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.dynamic.programming;

import java.util.ArrayList;
import java.util.List;

public class PerfectSquares {

   public static void main(String[] args) {
      System.out.println(numSquares(12));
      System.out.println(numSquares(13));
      System.out.println(numSquares(1));
   }

   public static int numSquares(int n) {
      List<Integer> numList = new ArrayList<>();
      for (int i = 1; i * i <= n; i++) {
         numList.add(i * i);
      }

      int[][] dp = new int[numList.size()][n + 1];
      for (int i = 0; i < dp[0].length; i++) {
         dp[0][i] = i;
      }

      for (int i = 1; i < dp.length; i++) {
         for (int j = 0; j < dp[0].length; j++) {
            Integer squareNumber = numList.get(i);
            if (squareNumber > j) {
               dp[i][j] = dp[i - 1][j];
            } else if (j % squareNumber == 0) {
               dp[i][j] = Math.min(dp[i - 1][j], j / squareNumber);
            } else {
               dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - squareNumber]);
            }
         }
      }

      return dp[dp.length - 1][dp[0].length - 1];
   }
}
