package com.coding.tasks.other;

public class Factorial {

   public static void main(String[] args) {
      System.out.println(factorial(4));
   }

   private static int factorial(int n) {
      int[] memo = new int[n + 1];
      memo[1] = 1;
      return factorialWithMemo(n, memo);
   }

   private static int factorialWithMemo(int n, int[] memo) {
      if (memo[n] == 0) {
         memo[n] = n * factorialWithMemo(n - 1, memo);
      }
      return memo[n];
   }
}
