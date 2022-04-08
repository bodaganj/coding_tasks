package com.coding.tasks.leetcode.first_round.amazon.dynamic_programming;

import java.util.List;

public class WordBreak {

   public static void main(String[] args) {
      System.out.println(wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
      System.out.println(wordBreak("ccbb", List.of("bc", "cb")));
      System.out.println(wordBreak("aaaaaaa", List.of("aaaa", "aa")));
      System.out.println(wordBreak("leetcode", List.of("leet", "code")));
      System.out.println(wordBreak("bogdan", List.of("maya", "yana")));
   }

   private static boolean wordBreak(String s, List<String> wordDict) {
      boolean[] f = new boolean[s.length() + 1];
      f[0] = true;

      char[] chars = s.toCharArray();
      for (int i = 1; i <= chars.length; i++) {
         for (String word : wordDict) {
            if (i >= word.length()) {
               if (f[i - word.length()] && s.startsWith(word, i - word.length())) {
                  f[i] = true;
                  break;
               }
            }
         }
      }

      return f[s.length()];
   }
}
