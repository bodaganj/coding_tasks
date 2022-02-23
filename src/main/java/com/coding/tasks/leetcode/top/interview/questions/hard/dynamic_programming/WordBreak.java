package com.coding.tasks.leetcode.top.interview.questions.hard.dynamic_programming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

   public static void main(String[] args) {
      System.out.println(wordBreak("leetcode", List.of("leet", "code")));
      System.out.println(wordBreak("cars", List.of("car", "ca", "rs")));
      System.out.println(wordBreak("azaza", List.of("ff", "fv")));
      System.out.println(wordBreak("cars", List.of("car", "ca", "s")));
      System.out.println(wordBreak("aaaaaaa", List.of("aaaa", "aaa", "asdf", "sdfd")));
   }

   private static boolean wordBreak(String s, List<String> wordDict) {
      if (s.isBlank()) {
         return true;
      }
      Set<String> set = new HashSet<>(wordDict);

      for (int i = 1; i <= s.length(); i++) {
         String substring = s.substring(0, i);

         if (set.contains(substring)) {
            if (wordBreak(s.replaceFirst(substring, ""), wordDict)) {
               return true;
            }
         }
      }

      return false;
   }
}
