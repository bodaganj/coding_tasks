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
      if (x == 0) {
         return 0;
      }
      char[] chars = String.valueOf(x).toCharArray();
      StringBuilder sb = new StringBuilder();
      for (char aChar : chars) {
         if (aChar == '-') {
            continue;
         }
         sb.append(aChar);
      }
      String finalString = sb.reverse().toString();
      String noZeroAtStart = finalString.replaceAll("^(0+)", "");
      int output;
      try {
         output = Integer.parseInt(noZeroAtStart);
      } catch (NumberFormatException ex) {
         return 0;
      }

      return chars[0] == '-' ? -1 * output : output;
   }
}
