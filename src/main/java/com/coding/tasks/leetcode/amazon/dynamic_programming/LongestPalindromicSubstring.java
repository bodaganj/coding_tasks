package com.coding.tasks.leetcode.amazon.dynamic_programming;

public class LongestPalindromicSubstring {

   public static void main(String[] args) {
      System.out.println(longestPalindrome("babad"));
   }

   private static String longestPalindrome(String s) {
      char[] chars = s.toCharArray();
      String longest = "";

      for (int i = 0; i < chars.length; i++) {
         String first = getPalindrome(i, i, chars);
         String second = getPalindrome(i, i + 1, chars);

         int length = longest.length();
         if (length < first.length()) {
            longest = first;
         }
         if (length < second.length()) {
            longest = second;
         }
      }

      return longest;
   }

   private static String getPalindrome(int left, int right, char[] chars) {
      StringBuilder sb = new StringBuilder();
      while (left >= 0 && left < chars.length && right >= 0 && right < chars.length && chars[left] == chars[right]) {
         left--;
         right++;
      }

      for (int i = left + 1; i < right; i++) {
         sb.append(chars[i]);
      }

      return sb.toString();
   }
}
