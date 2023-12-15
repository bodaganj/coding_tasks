package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.string;

public class ReverseInteger {

   public static void main(String[] args) {
      System.out.println(reverse(120));
      System.out.println(reverse(-5));
      System.out.println(reverse(123));
      System.out.println(reverse(1534236469));
   }

   public static int reverse(int x) {
      StringBuilder sb = new StringBuilder();
      String xx = Integer.toString(Math.abs(x));
      char[] chars = xx.toCharArray();
      for (int i = chars.length - 1; i >= 0; i--) {
         sb.append(chars[i]);
      }

      try {
         int ans = Integer.parseInt(sb.toString());
         return x < 0 ? -1 * ans : ans;
      } catch (NumberFormatException exception) {
         return 0;
      }
   }
}
