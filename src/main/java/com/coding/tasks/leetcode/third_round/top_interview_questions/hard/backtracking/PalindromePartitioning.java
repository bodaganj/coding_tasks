package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

   public static void main(String[] args) {
      System.out.println(partition("aab"));
   }

   public static List<List<String>> partition(String s) {
      List<List<String>> ans = new ArrayList<>();
      rec(s, new ArrayList<>(), ans);
      return ans;
   }

   private static void rec(String s, List<String> cur, List<List<String>> ans) {
      if (s.length() == 0) {
         ans.add(new ArrayList<>(cur));
      } else {
         for (int i = 1; i <= s.length(); i++) {
            String substring = s.substring(0, i);
            if (isPalindrome(substring)) {
               cur.add(substring);
               rec(s.substring(i), cur, ans);
               cur.remove(cur.size() - 1);
            }
         }
      }
   }

   private static boolean isPalindrome(String s) {
      StringBuilder sb = new StringBuilder(s);
      return s.equals(sb.reverse().toString());
   }
}
