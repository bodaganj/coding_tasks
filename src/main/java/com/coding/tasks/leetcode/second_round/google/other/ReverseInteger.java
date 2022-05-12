package com.coding.tasks.leetcode.second_round.google.other;

public class ReverseInteger {

   public static void main(String[] args) {
      System.out.println(reverse(-23));
      System.out.println(reverse(-120));
      System.out.println(reverse(256));
      System.out.println(reverse(0));
      System.out.println(reverse(1534236469));
   }

   private static int reverse(int x) {
      String finalString;
      StringBuilder sb = new StringBuilder();
      if (x < 0) {
         String str = x + "";
         sb.append(str.substring(1));
         finalString = "-" + sb.reverse();
      } else {
         sb.append(x);
         finalString = sb.reverse().toString();
      }

      try {
         return Integer.parseInt(finalString);
      } catch (NumberFormatException ex) {
         return 0;
      }
   }
}
