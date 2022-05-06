package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.dynamic_programming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordBreakII {

   public static void main(String[] args) {
      System.out.println(wordBreak("catsanddog", List.of("cat", "cats", "and", "sand", "dog")));
   }

   // recursion
   private static List<String> wordBreak(String s, List<String> wordDict) {
      List<String> ans = new ArrayList<>();
      Set<String> set = new HashSet<>(wordDict);

      dfs(s, set, "", ans);
      return ans.stream().distinct().collect(Collectors.toList());
   }

   private static void dfs(String s, Set<String> set, String current, List<String> ans) {
      if (s.isEmpty()) {
         ans.add(current.trim());
      } else {
         for (int i = 0; i <= s.length(); i++) {
            for (String word : set) {
               if (i >= word.length()) {
                  if (set.contains(s.substring(0, i))) {
                     dfs(s.substring(i), set, current + s.substring(0, i) + " ", ans);
                  }
               }
            }
         }
      }
   }
}
