package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.backtracking;

public class RegularExpressionMatching {

   public static void main(String[] args) {
      System.out.println(isMatch("abgcccfklm", "ab.c*f.*"));
      System.out.println(isMatch("aa", "a*"));
      System.out.println(isMatch("aab", "c*a*b"));
      System.out.println(isMatch("aaa", "ab*ac*a"));
   }

   private static boolean isMatch(String s, String p) {
      String pattern = removeRedundantAsterisks(p);
      boolean[][] dp = new boolean[s.length() + 1][pattern.length() + 1];
      dp[0][0] = true;
      for (int i = 1; i < dp[0].length; i++) {
         if (pattern.charAt(i - 1) == '*') {
            dp[0][i] = dp[0][i - 2];
         }
      }

      for (int i = 0; i < s.length(); i++) {
         for (int j = 0; j < pattern.length(); j++) {
            if (s.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.') {
               dp[i + 1][j + 1] = dp[i][j];
            } else if (pattern.charAt(j) == '*') {
               dp[i + 1][j + 1] = dp[i + 1][j - 1];
               if (pattern.charAt(j - 1) == '.' || pattern.charAt(j - 1) == s.charAt(i)) {
                  dp[i + 1][j + 1] = dp[i + 1][j + 1] | dp[i][j + 1];
               }
            }
         }
      }

      return dp[s.length()][pattern.length()];
   }

   private static String removeRedundantAsterisks(String p) {
      StringBuilder sb = new StringBuilder();
      boolean prev = false;
      int counter = 0;
      while (counter < p.length()) {
         char current = p.charAt(counter);
         if (current == '*') {
            if (!prev) {
               prev = true;
               sb.append(current);
            }
         } else {
            prev = false;
            sb.append(current);
         }
         counter++;
      }

      return sb.toString();
   }
}
