package com.coding.tasks.leetcode.first_round.top_interview_questions.easy.string;

public class ValidPalindrome {

   public static void main(String[] args) {
      System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
      System.out.println(isPalindrome("race a car"));
      System.out.println(isPalindrome(" "));
      System.out.println(isPalindrome("ab@a"));
   }

   private static boolean isPalindrome(String s) {
      String finalString = s.toLowerCase()
                            .replaceAll("\\s+", "")
                            .replaceAll("[-+.^:`~\",\\\\@#_{}\\[\\]'?;!()]", "");
      return finalString.equals(new StringBuilder(finalString).reverse().toString());
   }
}
