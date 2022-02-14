package com.coding.tasks.cracking.the.code.recursion_and_dp;

public class TripleStep {

   public static void main(String[] args) {
      System.out.println(getDifferentWays(3));
      System.out.println(getDifferentWays(5));
   }

   private static int getDifferentWays(int n) {
      int[] memo = new int[n + 1];
      return claim(0, n, memo);
   }

   private static int claim(int i, int n, int[] memo) {
      if (i == n) {
         return 1;
      } else if (i > n) {
         return 0;
      } else if (memo[i] > 0) {
         return memo[i];
      } else {
         memo[i] = claim(i + 1, n, memo) + claim(i + 2, n, memo);
         return memo[i];
      }
   }
}
