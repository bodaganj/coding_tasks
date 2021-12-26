package com.coding.tasks.other;

public class SumDigitsInNumber {

   public static void main(String[] args) {
      System.out.println(sum(112));
      System.out.println(sum(38));
      System.out.println(sum(999));
   }

   private static int sum(int n) {
      int sum = 0;

      while (n > 0) {
         sum += n % 10;
         n /= 10;
      }

      return sum;
   }
}
