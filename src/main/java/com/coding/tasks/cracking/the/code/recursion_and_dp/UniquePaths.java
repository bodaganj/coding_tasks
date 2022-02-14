package com.coding.tasks.cracking.the.code.recursion_and_dp;

public class UniquePaths {

   public static void main(String[] args) {
      System.out.println(uniquePaths(3, 7));
      System.out.println(uniquePaths(3, 2));
   }

   private static int uniquePaths(int m, int n) {
      int[][] memo = new int[m][n];
      return goNext(0, 0, m - 1, n - 1, memo);
   }

   private static int goNext(int x, int y, int m, int n, int[][] memo) {
      if (x == m && y == n) {
         return 1;
      } else if (x > m || y > n) {
         return 0;
      } else if (memo[x][y] > 0) {
         return memo[x][y];
      } else {
         memo[x][y] = goNext(x + 1, y, m, n, memo) + goNext(x, y + 1, m, n, memo);
         return memo[x][y];
      }
   }
}
