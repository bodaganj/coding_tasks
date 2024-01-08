package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.backtracking;

import java.util.HashMap;
import java.util.Map;

public class RegularExpressionMatching {

   public static void main(String[] args) {
//      System.out.println(isMatch("aa", "a")); // false
//      System.out.println(isMatch("aaa", "ab*a")); // false
//      System.out.println(isMatch("aab", "b.*")); // true
//      System.out.println(isMatch("aa", "a*")); // true
//      System.out.println(isMatch("aa", ".*")); // true
//      System.out.println(isMatch("aaa", ".*")); // true
//      System.out.println(isMatch("ab", ".*")); // true
//      System.out.println(isMatch("mississippi", "mis*is*ip*.")); // true
//      System.out.println(isMatch("aab", "c*a*b")); // true
//      System.out.println(isMatch("ab", ".*..")); // true
//      System.out.println(isMatch("a", "c*.")); // true
//      System.out.println(isMatch("a", "..*")); // true
//      System.out.println(isMatch("aaabaaaababcbccbaab", "c*c*.*c*a*..*c*")); // true
      System.out.println(isMatch("aaabaaaababcbccbaab", "b*a*a*.c*bb*b*.*.*")); // true
      System.out.println(isMatch("aaabaaaababcbccbaab", "b*a*a*.c*bb*b*.*.*")); // true
   }

   private static boolean isMatch(String s, String p) {
      if (s.equals(p)) {
         return true;
      }

      String pattern = simplifyPattern(p);
      pattern = simplifyMore(pattern);

      boolean[][] dp = new boolean[s.length() + 1][pattern.length() + 1];
      dp[0][0] = true;

      if (pattern.length() > 1 && pattern.charAt(1) == '*') {
         dp[0][1] = dp[0][2] = true;
      }

      for (int i = 0; i < pattern.length(); i++) {
         if (pattern.charAt(i) == '*') {
            dp[0][i + 1] = dp[0][i] || dp[0][i - 1];
            dp[0][i] = dp[0][i - 1];
         }
      }

      int j = 1;
      while (j < dp[0].length) {
         int i = 1;
         while (i < dp.length) {
            char curP = pattern.charAt(j - 1);
            char curS = s.charAt(i - 1);
            if (Character.isLetter(curP)) { // both letters
               if (curP == curS) {
                  if (j >= 2 && pattern.charAt(j - 2) == '*') {
                     dp[i][j] = dp[i - 1][j - 1] || dp[i - 1][j - 3];
                  } else {
                     dp[i][j] = dp[i - 1][j - 1];
                  }
               }
            } else {
               if (curP == '.') { // pattern is '.'
                  dp[i][j] = dp[i - 1][j - 1];
               } else { // pattern is '*'
                  char prevP = pattern.charAt(j - 2);
                  if (prevP == '.') {
                     dp[i][j] = dp[i - 1][j] || dp[i - 1][j - 1] || dp[i][j - 1] || dp[i][j - 2];
                  } else {
                     if (curS == pattern.charAt(j - 2)) {
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j] || dp[i][j - 2];
                     } else if (pattern.charAt(j - 1) == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                     } else {
                        dp[i][j] = dp[i][j - 2];
                     }
                  }
               }
            }
            i++;
         }
         j++;
      }

      return dp[s.length()][pattern.length()];
   }

   private static String simplifyMore(String pattern) {
      StringBuilder sb = new StringBuilder();
      Map<String, Integer> prev = new HashMap<>();

      for (int i = 0; i < pattern.length(); i++) {
         char c = pattern.charAt(i);
         if (c == '*') {
            String sameSubPattern = pattern.charAt(i - 1) + c + "";
            if (prev.containsKey(sameSubPattern) && prev.get(sameSubPattern) == i - 2) {
               sb.deleteCharAt(sb.length() - 1);
            } else {
               prev.put(sameSubPattern, i);
               sb.append(c);
            }
         } else {
            sb.append(c);
         }
      }
      return sb.toString();
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
