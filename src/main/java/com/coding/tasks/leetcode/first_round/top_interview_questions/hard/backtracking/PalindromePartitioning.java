package com.coding.tasks.leetcode.first_round.top_interview_questions.hard.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

   public static void main(String[] args) {
      System.out.println(partition("aab"));
   }

   private static List<List<String>> partition(String s) {
      List<List<String>> ans = new ArrayList<>();
      rec(s, new ArrayList<>(), ans);
      return ans;
   }

   private static void rec(String str, List<String> currentPalindromes, List<List<String>> ans) {
      if (str.isBlank()) {
         ans.add(currentPalindromes);
         return;
      }

      char[] chars = str.toCharArray();
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < chars.length; i++) {
         sb.append(chars[i]);

         if (isPalindrome(sb.toString())) {
            List<String> tmp = new ArrayList<>(currentPalindromes);
            tmp.add(sb.toString());

            rec(str.substring(i + 1), tmp, ans);
         }
      }
   }

   private static boolean isPalindrome(String str) {
      StringBuilder sb = new StringBuilder(str);
      return sb.reverse().toString().equals(str);
   }
}
