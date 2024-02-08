package com.coding.tasks.leetcode.third_round.fb.arrays.and.strings;

public class ValidPalindromeII {

   public static void main(String[] args) {
      System.out.println(validPalindrome("cbbcc"));
   }

   public static boolean validPalindrome(String s) {
      return isPalindrom(0, s.length() - 1, s, 0);
   }

   private static boolean isPalindrom(int leftIndex, int rightIndex, String s, int errors) {
      if (errors > 1) {
         return false;
      }
      while (leftIndex <= rightIndex) {
         if (s.charAt(leftIndex) == s.charAt(rightIndex)) {
            leftIndex++;
            rightIndex--;
         } else {
            return isPalindrom(leftIndex + 1, rightIndex, s, errors + 1) || isPalindrom(leftIndex, rightIndex - 1, s, errors + 1);
         }
      }
      return true;
   }
}
