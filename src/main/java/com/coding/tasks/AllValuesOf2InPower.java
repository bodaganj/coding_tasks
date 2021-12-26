package com.coding.tasks;

public class AllValuesOf2InPower {

   public static void main(String[] args) {
      calculate(65);
      System.out.println("======");
      recursion(65);
   }

   private static void calculate(int n) {
      int counter = 1;
      while (n / 2 != 1) {
         counter++;
         n = n / 2;
      }

      System.out.println(Math.pow(2, counter));
   }

   private static int recursion(int n) {
      if (n < 1) {
         return 0;
      }
      if (n == 1) {
         System.out.println(1);
         return 1;
      }

      int curr = recursion(n / 2) * 2;
      System.out.println(curr);
      return curr;
   }
}
