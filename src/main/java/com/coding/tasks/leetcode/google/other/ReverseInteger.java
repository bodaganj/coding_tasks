package com.coding.tasks.leetcode.google.other;

public class ReverseInteger {

   public static void main(String[] args) {
      System.out.println(reverse(-23));
      System.out.println(reverse(-120));
      System.out.println(reverse(256));
      System.out.println(reverse(0));
      System.out.println(reverse(1534236469));
   }

   private static int reverse(int x) {
      String reversed = new StringBuilder().append(Math.abs(x)).reverse().toString();
      try {
         return x < 0 ? Integer.parseInt(reversed) * -1 : Integer.parseInt(reversed);
      } catch (NumberFormatException ex) {
         return 0;
      }
   }
}
