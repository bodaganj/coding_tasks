package com.coding.tasks.leetcode.amazon.others;

public class ReverseInteger {

   public static void main(String[] args) {
      System.out.println(reverse(-23));
      System.out.println(reverse(-120));
      System.out.println(reverse(256));
      System.out.println(reverse(0));
      System.out.println(reverse(1534236469));
   }

   private static int reverse(int x) {
      StringBuilder sb = new StringBuilder();
      sb.append(Math.abs(x));
      sb.reverse();

      int i;
      try {
         i = Integer.parseInt(sb.toString());
      } catch (NumberFormatException e) {
         return 0;
      }

      return x < 0 ? i * -1 : i;
   }
}
