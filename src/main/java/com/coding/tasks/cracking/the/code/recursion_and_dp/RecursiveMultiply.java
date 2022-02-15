package com.coding.tasks.cracking.the.code.recursion_and_dp;

public class RecursiveMultiply {

   private static int value;

   public static void main(String[] args) {
      System.out.println(mult(5, 6));
   }

   private static int mult(int a, int b) {
      value = 0;
      return rec(a, b, 0);
   }

   private static int rec(int a, int b, int counter) {
      if (counter == b) {
         return value;
      } else {
         value += a;
         return rec(a, b, counter + 1);
      }
   }
}
