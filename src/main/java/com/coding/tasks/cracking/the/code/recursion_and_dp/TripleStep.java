package com.coding.tasks.cracking.the.code.recursion_and_dp;

public class TripleStep {

   private static int counter;

   public static void main(String[] args) {
      System.out.println(getDifferentWays(3));
      System.out.println(getDifferentWays(5));
   }

   private static int getDifferentWays(int n) {
      counter = 0;
      claim(n);
      return counter;
   }

   private static void claim(int n) {
      if (n == 0) {
         counter++;
      } else {
         if (n - 1 >= 0) {
            claim(n - 1);
         }
         if (n - 2 >= 0) {
            claim(n - 2);
         }
      }
   }
}
