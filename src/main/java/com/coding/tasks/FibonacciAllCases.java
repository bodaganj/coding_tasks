package com.coding.tasks;

public class FibonacciAllCases {

   public static void main(String[] args) {
      System.out.println(recursion(6));
      System.out.println(dp(6));
      System.out.println(bottomUp(6));
   }

   private static int recursion(int n) {
      int result;
      if (n == 1 || n == 2) {
         result = 1;
      } else {
         result = recursion(n - 1) + recursion(n - 2);
      }
      return result;
   }

   private static int dp(int n) {
      int[] memo = new int[n + 1];
      return dp(n, memo);
   }

   private static int dp(int n, int[] memo) {
      if (memo[n] != 0) {
         return memo[n];
      }

      int result;
      if (n == 1 || n == 2) {
         memo[1] = memo[2] = 1;
         result = 1;
      } else {
         result = recursion(n - 1) + recursion(n - 2);
      }
      memo[n] = result;
      return result;
   }

   private static int bottomUp(int n) {
      int[] array = new int[n + 1];
      array[1] = 1;
      array[2] = 1;
      for (int i = 3; i <= n; i++) {
         array[i] = array[i - 1] + array[i - 2];
      }
      return array[n];
   }
}
