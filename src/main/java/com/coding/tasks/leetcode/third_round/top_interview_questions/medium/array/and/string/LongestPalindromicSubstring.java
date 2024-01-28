package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.array.and.string;

import java.util.LinkedList;

public class LongestPalindromicSubstring {

   public static void main(String[] args) {

   }

   public String longestPalindrome(String s) {
      if (s.length() == 1) {
         return s;
      }

      String longest = "";
      for (int i = 0; i < s.length(); i++) {
         String longest1 = getLongest(s, i, i);
         String longest2 = getLongest(s, i, i + 1);
         if (longest1.length() > longest.length()) {
            longest = longest1;
         }
         if (longest2.length() > longest.length()) {
            longest = longest2;
         }
      }
      return longest;
   }

   private String getLongest(String s, int left, int right) {
      LinkedList<Character> list = new LinkedList<>();
      while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
         if (left == right) {
            list.addFirst(s.charAt(left));
         } else {
            list.addFirst(s.charAt(left));
            list.addLast(s.charAt(right));
         }
         left--;
         right++;
      }
      StringBuilder sb = new StringBuilder();
      for (Character character : list) {
         sb.append(character);
      }

      return sb.toString();
   }
}
