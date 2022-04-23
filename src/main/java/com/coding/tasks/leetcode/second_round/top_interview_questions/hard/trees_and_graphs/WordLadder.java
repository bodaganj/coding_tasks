package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.trees_and_graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordLadder {

   private static int min = Integer.MAX_VALUE;

   public static void main(String[] args) {
      System.out.println(ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog")));
//      System.out.println(ladderLength("a", "c", List.of("a", "b", "c")));
   }

   // TLE !!!!!!
   private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
      min = Integer.MAX_VALUE;
      Set<String> dictionary = new HashSet<>(wordList);
      if (!dictionary.contains(endWord)) {
         return 0;
      }
      Map<String, List<String>> similarWords = getSimilarWords(beginWord, wordList);

      getAmount(new HashSet<>(), beginWord, endWord, similarWords, 1);
      return min == Integer.MAX_VALUE ? 0 : min;
   }

   private static void getAmount(Set<String> visited, String currentWord, String endWord, Map<String, List<String>> similarWords, int currentCounter) {
      if (currentCounter >= min) {
         return;
      }
      if (currentWord.equals(endWord)) {
         min = currentCounter;
      } else {
         for (String str : similarWords.get(currentWord)) {
            if (!visited.contains(str)) {
               visited.add(str);
               getAmount(visited, str, endWord, similarWords, currentCounter + 1);
               visited.remove(str);
            }
         }
      }
   }

   private static Map<String, List<String>> getSimilarWords(String beginWord, List<String> wordList) {
      Map<String, List<String>> mapping = new HashMap<>();
      for (String str : wordList) {
         if (areSimilar(beginWord, str)) {
            List<String> orDefault1 = mapping.getOrDefault(beginWord, new ArrayList<>());
            orDefault1.add(str);
            mapping.put(beginWord, orDefault1);

            List<String> orDefault2 = mapping.getOrDefault(str, new ArrayList<>());
            orDefault2.add(beginWord);
            mapping.put(str, orDefault2);
         }
      }

      for (int i = 0; i < wordList.size(); i++) {
         String str = wordList.get(i);
         for (int j = i + 1; j < wordList.size(); j++) {
            String word = wordList.get(j);
            if (areSimilar(str, word)) {
               List<String> orDefault1 = mapping.getOrDefault(str, new ArrayList<>());
               orDefault1.add(word);
               mapping.put(str, orDefault1);

               List<String> orDefault2 = mapping.getOrDefault(word, new ArrayList<>());
               orDefault2.add(str);
               mapping.put(word, orDefault2);
            }
         }
      }

      return mapping;
   }

   private static boolean areSimilar(String begin, String end) {
      int dif = 0;
      for (int i = 0; i < begin.length(); i++) {
         if (begin.charAt(i) != end.charAt(i)) {
            dif++;
         }
         if (dif > 1) {
            return false;
         }
      }
      return true;
   }
}
