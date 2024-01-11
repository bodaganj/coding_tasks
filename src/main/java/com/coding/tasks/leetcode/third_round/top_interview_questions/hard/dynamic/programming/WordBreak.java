package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.dynamic.programming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak {

   public static void main(String[] args) {
      System.out.println(wordBreak("leetcode", List.of("leet", "code")));
      System.out.println(wordBreak("applepenapple", List.of("apple", "pen")));
      System.out.println(wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
   }

//   public static boolean wordBreak(String s, List<String> wordDict) {
//
//   }

   public static boolean wordBreak(String s, List<String> wordDict) {
      Set<String> words = new HashSet<>(wordDict);
      if (!checkAllNeededLetters(s, wordDict)) {
         return false;
      }
      return recursion(0, s, words);
   }

   private static boolean recursion(int index, String s, Set<String> words) {
      if (index == s.length()) {
         return true;
      } else {
         for (int i = index + 1; i <= s.length(); i++) {
            if (words.contains(s.substring(index, i))) {
               if (recursion(i, s, words)) {
                  return true;
               }
            }
         }
         return false;
      }
   }

   private static boolean checkAllNeededLetters(String s, List<String> wordDict) {
      Map<Character, Integer> sMap = new HashMap<>();
      for (char c : s.toCharArray()) {
         sMap.put(c, sMap.getOrDefault(c, 0) + 1);
      }

      Map<Character, Integer> wordsMap = new HashMap<>();
      for (String word : wordDict) {
         for (char c : word.toCharArray()) {
            wordsMap.put(c, sMap.getOrDefault(c, 0) + 1);
         }
      }

      for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
         if (!wordsMap.containsKey(entry.getKey())) {
            return false;
         }
      }

      return true;
   }

   private record Pair(int index, String word) {

   }
}
