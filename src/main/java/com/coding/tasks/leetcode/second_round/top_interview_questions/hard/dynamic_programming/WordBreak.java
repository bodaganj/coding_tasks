package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.dynamic_programming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

   public static void main(String[] args) {
      System.out.println(wordBreak("leetcode", List.of("leet", "code"))); // true
      System.out.println(wordBreak("applepenapple", List.of("apple", "pen"))); // true
      System.out.println(wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat"))); // false
   }

   private static boolean wordBreak(String s, List<String> wordDict) {
      boolean[] dp = new boolean[s.length() + 1];
      dp[0] = true;
      Set<String> set = new HashSet<>(wordDict);

      //Second DP
      for (int i = 1; i <= s.length(); i++) {
         for (int j = 0; j < i; j++) {
            if (dp[j] && set.contains(s.substring(j, i))) {
               dp[i] = true;
               break;
            }
         }
      }

      return dp[s.length()];
   }
}
