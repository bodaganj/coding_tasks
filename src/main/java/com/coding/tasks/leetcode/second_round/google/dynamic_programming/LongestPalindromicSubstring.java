package com.coding.tasks.leetcode.second_round.google.dynamic_programming;

import java.util.LinkedList;

public class LongestPalindromicSubstring {

   public static void main(String[] args) {
      System.out.println(longestPalindrome("ababad"));
      System.out.println(longestPalindrome("babad"));
      System.out.println(longestPalindrome("cbbd"));
      System.out.println(longestPalindrome("asdf"));
      System.out.println(longestPalindrome("bb"));
      System.out.println(longestPalindrome("aacabdkacaa"));
   }

   private static String longestPalindrome(String s) {
      String maxString = s.substring(s.length() - 1);
      for (int i = 0; i < s.length() - 1; i++) {
         String odd = getMaxPalindromeLength(s, i, i);
         String even = getMaxPalindromeLength(s, i, i + 1);

         if (odd.length() > maxString.length()) {
            maxString = odd;
         }
         if (even.length() > maxString.length()) {
            maxString = even;
         }
      }
      return maxString;
   }

   private static String getMaxPalindromeLength(String s, int left, int right) {
      LinkedList<String> list = new LinkedList<>();
      while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
         if (left == right) {
            list.add(s.charAt(left) + "");
         } else {
            list.addFirst(s.charAt(left) + "");
            list.addLast(s.charAt(right) + "");
         }
         left--;
         right++;
      }
      return String.join("", list);
   }
}
