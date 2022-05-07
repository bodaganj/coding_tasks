package com.coding.tasks.leetcode.second_round.amazon.dynamic_programming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak {

   public static void main(String[] args) {
      System.out.println(wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat"))); // false
      System.out.println(wordBreak("ccbb", List.of("bc", "cb"))); // false
      System.out.println(wordBreak("aaaaaaa", List.of("aaaa", "aa"))); // false
      System.out.println(wordBreak("leetcode", List.of("leet", "code"))); // true
      System.out.println(wordBreak("bogdan", List.of("maya", "yana"))); // false
   }

   private static boolean wordBreak(String s, List<String> wordDict) {
      Map<String, Boolean> memo = new HashMap<>();
      return rec(s, new HashSet<>(wordDict), memo);
   }

   private static boolean rec(String s, Set<String> set, Map<String, Boolean> memo) {
      if (s.isEmpty()) {
         return true;
      }

      if (memo.containsKey(s)) {
         return memo.get(s);
      }

      for (int i = 1; i <= s.length(); i++) {
         String substring = s.substring(0, i);
         if (set.contains(substring)) {
            boolean flag = rec(s.substring(i), set, memo);
            if (flag) {
               memo.put(s, true);
               return true;
            }
         }
      }

      memo.put(s, false);
      return false;
   }
}
