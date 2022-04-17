package com.coding.tasks.leetcode.second_round.amazon.arrays_and_strings;

public class StringToIntegerAtoi {

   public static void main(String[] args) {
      System.out.println(myAtoi("4193 with words")); // 4193
      System.out.println(myAtoi("   -42"));          // -42
      System.out.println(myAtoi("42"));              // 42
      System.out.println(myAtoi("azaza 42"));        // 0
      System.out.println(myAtoi("-91283472332"));    // -2147483648
      System.out.println(myAtoi("+-12"));            // 0
      System.out.println(myAtoi("  +  413"));        // 0
   }

   private static int myAtoi(String s) {
      StringBuilder sb = new StringBuilder();
      StringBuilder signBuilder = new StringBuilder();
      for (char c : s.toCharArray()) {
         if (c != ' ' || sb.length() != 0 || signBuilder.length() != 0) {
            if ((c == '-' || c == '+') && sb.length() == 0 && signBuilder.length() == 0) {
               signBuilder.append(c);
            } else if (Character.isDigit(c)) {
               sb.append(c);
            } else {
               break;
            }
         }
      }

      if (sb.length() == 0) {
         return 0;
      }

      int sign = signBuilder.length() == 0 || signBuilder.toString().equals("+") ? 1 : -1;
      int result;
      try {
         result = Integer.parseInt(sb.toString());
      } catch (NumberFormatException exception) {
         return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }

      return sign * result;
   }
}
