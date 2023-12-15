package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.string;

public class ValidPalindrome {

   public static void main(String[] args) {
      System.out.println(isPalindrome("0P"));
   }

   public static boolean isPalindrome(String s) {
      StringBuilder sb = new StringBuilder();
      for (char c : s.toCharArray()) {
         if (Character.isAlphabetic(c) || Character.isDigit(c)) {
            String tmp = c + "";
            sb.append(tmp.toLowerCase());
         }
      }
      return sb.toString().equals(sb.reverse().toString());
   }
}
