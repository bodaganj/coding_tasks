package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.array_and_strings;

import java.util.LinkedList;
import java.util.List;

public class LongestPalindromicSubstring {

   public static void main(String[] args) {
      System.out.println(longestPalindrome("babad"));
      System.out.println(longestPalindrome("cbbd"));
   }

   private static String longestPalindrome(String s) {
      String longest = "";
      char[] chars = s.toCharArray();

      for (int i = 0; i < chars.length; i++) {
         String str1 = getPalindrome(chars, i, i);
         String str2 = getPalindrome(chars, i, i + 1);

         if (longest.length() < str1.length()) {
            longest = str1;
         }
         if (longest.length() < str2.length()) {
            longest = str2;
         }
      }

      return longest;
   }

   private static String getPalindrome(char[] chars, int left, int right) {
      LinkedList<Character> sb = new LinkedList<>();
      while (left >= 0 && right < chars.length) {
         if (left != right) {
            if (chars[left] == chars[right]) {
               sb.addFirst(chars[left]);
               sb.addLast(chars[left]);
            } else {
               return getStr(sb);
            }
         } else {
            sb.add(chars[left]);
         }
         left--;
         right++;
      }

      return getStr(sb);
   }

   private static String getStr(List<Character> list) {
      StringBuilder sb = new StringBuilder();
      for (Character character : list) {
         sb.append(character);
      }
      return sb.toString();
   }
}
