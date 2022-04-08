package com.coding.tasks.leetcode.first_round.top_interview_questions.medium.dynamic_programming;

import java.util.Arrays;

public class UniquePaths {

   public static void main(String[] args) {
      System.out.println(uniquePaths(3, 2));
   }

   private static int uniquePaths(int m, int n) {
      int[][] memo = new int[m][n];
      for (int[] ints : memo) {
         Arrays.fill(ints, -1);
      }

      return dfs(new Tuple(0, 0), new Tuple(m - 1, n - 1), memo);
   }

   private static int dfs(Tuple current, Tuple finish, int[][] memo) {
      if (current.x < 0 || current.x > finish.x || current.y < 0 || current.y > finish.y) {
         return 0;
      }

      if (memo[current.x][current.y] > -1) {
         return memo[current.x][current.y];
      }

      if (current.equals(finish)) {
         return 1;
      }

      memo[current.x][current.y] = dfs(new Tuple(current.x + 1, current.y), finish, memo) +
         dfs(new Tuple(current.x, current.y + 1), finish, memo);
      return memo[current.x][current.y];
   }

   static class Tuple {

      public int x;
      public int y;

      public Tuple(int x, int y) {
         this.x = x;
         this.y = y;
      }

      @Override
      public boolean equals(Object o) {
         Tuple t = (Tuple) o;
         return t != null && t.x == this.x && t.y == this.y;
      }

      @Override
      public int hashCode() {
         return x * 31 + y;
      }
   }

   /**
    * Better way to do!!!!!
    */
//   private static int uniquePaths(int m, int n) {
//      int[][] d = new int[m][n];
//
//      for(int[] arr : d) {
//         Arrays.fill(arr, 1);
//      }
//      for(int col = 1; col < m; ++col) {
//         for(int row = 1; row < n; ++row) {
//            d[col][row] = d[col - 1][row] + d[col][row - 1];
//         }
//      }
//      return d[m - 1][n - 1];
//   }
}
