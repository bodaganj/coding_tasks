package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.backtracking;

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

   private static void rec(String s, List<String> current, List<List<String>> ans) {
      if (s.isEmpty()) {
         ans.add(current);
      } else {
         StringBuilder sb = new StringBuilder();
         for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (isPalindrome(sb.toString())) {
               List<String> newCurrent = new ArrayList<>(current);
               newCurrent.add(sb.toString());
               rec(s.substring(i + 1), newCurrent, ans);
            }
         }
      }
   }

   private static boolean isPalindrome(String str) {
      int left = 0;
      int right = str.length() - 1;
      while (left < right) {
         if (str.charAt(left) != str.charAt(right)) {
            return false;
         }
         left++;
         right--;
      }
      return true;
   }
}
