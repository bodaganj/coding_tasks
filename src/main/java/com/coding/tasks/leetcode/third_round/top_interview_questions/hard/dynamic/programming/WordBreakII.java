package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.dynamic.programming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordBreakII {

   public static void main(String[] args) {
      System.out.println(wordBreak("catsanddog", List.of("cat", "cats", "and", "sand", "dog")));
   }

   public static List<String> wordBreak(String s, List<String> wordDict) {
      Set<String> set = new HashSet<>(wordDict);
      List<List<String>> ans = new ArrayList<>();
      rec(s, new ArrayList<>(), set, ans);
      return ans.stream().map(list -> String.join(" ", list)).collect(Collectors.toList());
   }

   private static void rec(String s, List<String> current, Set<String> set, List<List<String>> ans) {
      if (s.isEmpty()) {
         ans.add(new ArrayList<>(current));
      } else {
         for (String word : set) { // O(S) * O(W) * O(k), where s - string, w - list of words, k - word length
            if (s.length() >= word.length() && s.startsWith(word)) {
               current.add(word);
               rec(s.substring(word.length()), current, set, ans);
               current.remove(current.size() - 1);
            }
         }
      }
   }
}
