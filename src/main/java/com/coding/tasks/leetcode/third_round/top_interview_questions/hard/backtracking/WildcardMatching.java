package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.backtracking;

public class WildcardMatching {

   public static void main(String[] args) {
      System.out.println(isMatch("aa", "a"));
      System.out.println(isMatch("aa", "*"));
      System.out.println(isMatch("cb", "?a"));
      System.out.println(isMatch("cb", "?b"));
      System.out.println(isMatch("adceb", "*a*b"));
      System.out.println(isMatch("", ""));
   }

   public static boolean isMatch(String s, String p) {
      if (s.isEmpty() && p.isEmpty()) {
         return true;
      } else if (p.isEmpty()) {
         return false;
      }

      String pattern = simplifyPattern(p);
      boolean[][] dp = new boolean[s.length() + 1][pattern.length() + 1];
      dp[0][0] = true;
      if (pattern.charAt(0) == '*') {
         dp[0][1] = true;
      }

      for (int i = 1; i < dp.length; i++) {
         for (int j = 1; j < dp[0].length; j++) {
            char currPatter = pattern.charAt(j - 1);
            char currString = s.charAt(i - 1);

            if (Character.isLetter(currPatter)) {
               if (currString == currPatter) {
                  dp[i][j] = dp[i - 1][j - 1];
               }
            } else {
               if (currPatter == '?') {
                  dp[i][j] = dp[i - 1][j - 1];
               } else {
                  dp[i][j] = dp[i - 1][j - 1] || dp[i - 1][j] || dp[i][j - 1];
               }
            }
         }
      }

      return dp[s.length()][pattern.length()];
   }

   private static String simplifyPattern(String pattern) {
      StringBuilder sb = new StringBuilder();
      boolean isPrevAsterisk = false;
      for (int i = 0; i < pattern.length(); i++) {
         char cur = pattern.charAt(i);
         if (cur == '*') {
            if (!isPrevAsterisk) {
               isPrevAsterisk = true;
               sb.append(cur);
            }
         } else {
            sb.append(cur);
            isPrevAsterisk = false;
         }
      }
      return sb.toString();
   }
}
