package com.coding.tasks.leetcode.third_round.google.others;

public class ReverseInteger {

   public static void main(String[] args) {
      System.out.println(reverse(123));
      System.out.println(reverse(-123));
   }

   public static int reverse(int x) {
      try {
         int ans = Integer.parseInt(new StringBuilder(Math.abs(x) + "").reverse().toString());
         return x > 0 ? ans : -ans;
      } catch (NumberFormatException e) {
         return 0;
      }
   }
}
