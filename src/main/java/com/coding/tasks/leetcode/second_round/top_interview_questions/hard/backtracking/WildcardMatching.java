package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.backtracking;

public class WildcardMatching {

   public static void main(String[] args) {
      System.out.println(isMatch("aa", "a"));
      System.out.println(isMatch("aa", "*"));
      System.out.println(isMatch("cb", "?a"));
      System.out.println(isMatch("adceb", "*a*b"));
      System.out.println(isMatch("", "****"));
      System.out.println(isMatch("", ""));
   }

   private static boolean isMatch(String s, String p) {
      StringBuilder sb = new StringBuilder();
      boolean flag = false;
      for (char c : p.toCharArray()) {
         if (c == '*') {
            if (!flag) {
               sb.append(c);
               flag = true;
            }
         } else {
            flag = false;
            sb.append(c);
         }
      }
      String pattern = sb.toString();

      boolean[][] dp = new boolean[s.length() + 1][pattern.length() + 1];
      dp[0][0] = true;
      if (!pattern.isEmpty() && pattern.charAt(0) == '*') {
         dp[0][1] = true;
      }

      for (int i = 1; i < dp.length; i++) {
         for (int j = 1; j < dp[0].length; j++) {
            int x = i - 1;
            int y = j - 1;

            if (s.charAt(x) == pattern.charAt(y) || pattern.charAt(y) == '?') {
               dp[i][j] = dp[i - 1][j - 1];
            } else if (pattern.charAt(y) == '*') {
               if (dp[i][j - 1] || dp[i - 1][j]) {
                  dp[i][j] = true;
               }
            }
         }
      }

      return dp[s.length()][pattern.length()];
   }
}
