package com.coding.tasks.other;

public class Division {

   public static void main(String[] args) {
      System.out.println(divWithoutMath(7, 3));
      System.out.println(divWithoutMath(16, 6));
   }

   private static int divWithoutMath(int a, int b) {
      if (b < 1) {
         return -1;
      } else {
         int div = a / b;
         return a - div * b;
      }
   }
}
