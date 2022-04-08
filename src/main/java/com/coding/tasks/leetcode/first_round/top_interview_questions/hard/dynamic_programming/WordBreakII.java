package com.coding.tasks.leetcode.first_round.top_interview_questions.hard.dynamic_programming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {

   public static void main(String[] args) {
      System.out.println(wordBreak("catsanddog", List.of("cat", "cats", "and", "sand", "dog")));
   }

   // recursion
   private static List<String> wordBreak(String s, List<String> wordDict) {
      List<String> ans = new ArrayList<>();
      rec(s, new HashSet<>(wordDict), "", ans);
      return ans;
   }

   private static void rec(String str, Set<String> wordDict, String current, List<String> ans) {
      if (str.isBlank()) {
         ans.add(current.trim());
      }

      for (int i = 1; i <= str.length(); i++) {
         String substring = str.substring(0, i);
         if (wordDict.contains(substring)) {
            rec(str.replaceFirst(substring, ""), wordDict, current + " " + substring, ans);
         }
      }
   }
}
