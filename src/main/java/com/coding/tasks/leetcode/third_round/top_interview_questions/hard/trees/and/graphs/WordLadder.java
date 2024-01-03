package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.trees.and.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

   public static void main(String[] args) {
      System.out.println(ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog")));
      System.out.println(ladderLength("leet", "code", List.of("lest", "leet", "lose", "code", "lode", "robe", "lost")));
   }

   public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
      if (!wordList.contains(endWord)) {
         return 0;
      }

      Set<String> seen = new HashSet<>();
      Map<String, Set<String>> wordMapping = new HashMap<>();
      Set<String> wordsForBegin = getOneLetterDif(beginWord, wordList);
      if (wordsForBegin.contains(endWord)) {
         return 2;
      } else {
         wordMapping.put(beginWord, wordsForBegin);
      }
      for (String word : wordList) {
         if (!word.equals(endWord) && !word.equals(beginWord)) {
            wordMapping.put(word, getOneLetterDif(word, wordList));
         }
      }

      int count = 0;
      Queue<String> queue = new LinkedList<>();
      queue.add(beginWord);
      while (!queue.isEmpty()) {
         int size = queue.size();
         count++;
         while (size > 0) {
            String poll = queue.poll();
            seen.add(poll);

            if (poll.equals(endWord)) {
               return count;
            } else {
               for (String word : wordMapping.get(poll)) {
                  if (!seen.contains(word)) {
                     queue.add(word);
                  }
               }
            }
            size--;
         }
      }

      return 0;
   }

   private static Set<String> getOneLetterDif(String word, List<String> wordList) {
      Set<String> set = new HashSet<>();
      for (String s : wordList) {
         if (!s.equals(word)) {
            if (isOneLetterDif(word, s)) {
               set.add(s);
            }
         }
      }

      return set;
   }

   private static boolean isOneLetterDif(String word, String current) {
      boolean oneMistake = false;
      int index = 0;
      while (index < word.length()) {
         if (word.charAt(index) != current.charAt(index)) {
            if (oneMistake) {
               return false;
            } else {
               oneMistake = true;
            }
         }
         index++;
      }
      return true;
   }
}
