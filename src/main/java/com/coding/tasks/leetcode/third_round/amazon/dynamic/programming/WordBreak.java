package com.coding.tasks.leetcode.third_round.amazon.dynamic.programming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

   public static void main(String[] args) {
      System.out.println(wordBreak("leetcode", List.of("leet", "code"))); // true
      System.out.println(wordBreak("a", List.of("b"))); // false
      System.out.println(wordBreak("aaaaaaa", List.of("aaaa", "aaa"))); // true
      System.out.println(wordBreak("abcd", List.of("a", "abc", "b", "cd"))); // true
   }

   public static boolean wordBreak(String s, List<String> wordDict) {
      int minLength = Integer.MAX_VALUE;
      int maxLength = Integer.MIN_VALUE;
      Set<String> set = new HashSet<>();
      for (String word : wordDict) {
         minLength = Math.min(minLength, word.length());
         maxLength = Math.max(maxLength, word.length());
         set.add(word);
      }

      boolean[] dp = new boolean[s.length() + 1];
      dp[0] = true;

      int i = 0;
      while (i <= s.length() - minLength && dp[i]) {
         StringBuilder sb = new StringBuilder();
         int j = i;
         while (j < i + maxLength && j < s.length()) {
            sb.append(s.charAt(j));
            if (set.contains(sb.toString())) {
               dp[j + 1] = true;
            }
            j++;
         }
         i++;
         while (!dp[i] && i < s.length()) {
            i++;
         }
      }

      return dp[dp.length - 1];
   }
}
