package com.coding.tasks;

public class PrimeNumber {

   public static void main(String[] args) {
      System.out.println(isPrimeNumber(5));
      System.out.println(isPrimeNumber(33));
      System.out.println(isPrimeNumber(29));
   }

   private static boolean isPrimeNumber(int n) {
      for (int i = 2; i < Math.sqrt(n); i++) {
         if (n % i == 0) {
            return false;
         }
      }
      return true;
   }
}
