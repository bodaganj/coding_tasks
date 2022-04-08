package com.coding.tasks.leetcode.first_round.top_interview_questions.easy.string;

public class ReverseInteger {

   public static void main(String[] args) {
      System.out.println(reverse(234));
      System.out.println(reverse(-20));
      System.out.println(reverse(0));
      System.out.println(reverse(1534236469));
   }

   private static int reverse(int x) {
      String string = new StringBuilder(String.valueOf(x)).reverse().toString();
      if (string.charAt(string.length() - 1) == '-') {
         string = "-" + string.substring(0, string.length() - 1);
      }

      try {
         return Integer.parseInt(string);
      } catch (NumberFormatException ex) {
         return 0;
      }
   }

   private static int reverse2(int x) {
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
