package com.coding.tasks.leetcode.first_round.top_interview_questions.easy.string;

import java.math.BigInteger;

public class StringToInteger {

   public static void main(String[] args) {
//      System.out.println(myAtoi("42"));
//      System.out.println(myAtoi("   -42"));
      System.out.println(myAtoi("-91283472332"));
//      System.out.println(myAtoi("4193 with words"));
   }

   private static int myAtoi(String s) {
      String noSpaces = s.replaceAll("^\\s*", "");
      char[] chars = noSpaces.toCharArray();
      StringBuilder sb = new StringBuilder();
      if (noSpaces.charAt(0) == '-' || noSpaces.charAt(0) == '+') {
         sb.append(noSpaces.charAt(0));
      }
      int i = sb.length() == 1 ? 1 : 0;
      while (i < chars.length && Character.isDigit(chars[i])) {
         sb.append(chars[i]);
         i++;
      }
      if (sb.length() != 0) {
         BigInteger bi = new BigInteger(sb.toString());
         return bi.intValue();
      } else {
         return 0;
      }
   }
}
