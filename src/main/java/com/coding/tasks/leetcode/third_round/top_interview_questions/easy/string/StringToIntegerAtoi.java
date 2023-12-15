package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.string;

public class StringToIntegerAtoi {

   public static void main(String[] args) {
      System.out.println(myAtoi("42"));
      System.out.println(myAtoi("       -42"));
      System.out.println(myAtoi("-91283472332"));
      System.out.println(myAtoi(""));
   }

   public static int myAtoi(String s) {
      String trim = s.trim();
      String finalStr;
      boolean isNegative = false;
      if (trim.length() > 1 && trim.charAt(0) == '-') {
         isNegative = true;
         finalStr = trim.substring(1);
      } else if (trim.length() > 0 && trim.charAt(0) == '+') {
         finalStr = trim.substring(1);
      } else {
         finalStr = trim;
      }

      char[] chars = finalStr.toCharArray();
      int i = 0;
      StringBuilder sb = new StringBuilder();
      while (i < chars.length && Character.isDigit(chars[i])) {
         sb.append(chars[i]);
         i++;
      }

      if (sb.length() > 0) {
         try {
            return isNegative ? Integer.parseInt(sb.toString()) * -1 : Integer.parseInt(sb.toString());
         } catch (NumberFormatException e) {
            return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
         }
      } else {
         return 0;
      }
   }
}
