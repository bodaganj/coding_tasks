package com.coding.tasks.leetcode.amazon.trees_and_graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {

   public static void main(String[] args) {

   }

   private static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
      if (!wordList.contains(endWord)) {
         return Collections.emptyList();
      }

      Set<List<String>> result = new HashSet<>();
      int amountOfWords = Integer.MAX_VALUE;

      Map<String, List<String>> adjacent = getAdjacent(beginWord, wordList);

      Queue<String> queue = new LinkedList<>();
      queue.offer(beginWord);

      Queue<List<String>> pathQueue = new LinkedList<>();
      List<String> beginWordList = new ArrayList<>();
      beginWordList.add(beginWord);
      pathQueue.offer(beginWordList);

      Queue<Set<String>> visitedQueue = new LinkedList<>();
      Set<String> set = new HashSet<>();
      set.add(beginWord);
      visitedQueue.offer(set);

      while (!queue.isEmpty()) {
         String poll = queue.poll();
         List<String> pathPoll = pathQueue.poll();
         Set<String> visitedPoll = visitedQueue.poll();

         List<String> list = adjacent.get(poll);

         for (String word : list) {
            if (!visitedPoll.contains(word)) {
               if (word.equals(endWord)) {
                  if (pathPoll.size() + 1 < amountOfWords) {
                     amountOfWords = pathPoll.size() + 1;
                     List<String> newList = new ArrayList<>(pathPoll);
                     newList.add(word);
                     result = new HashSet<>();
                     result.add(newList);
                  } else if (pathPoll.size() + 1 == amountOfWords) {
                     List<String> newList = new ArrayList<>(pathPoll);
                     newList.add(word);
                     result.add(newList);
                  }
               } else {
                  if (pathPoll.size() + 1 < amountOfWords) {
                     queue.offer(word);

                     List<String> newList = new ArrayList<>(pathPoll);
                     newList.add(word);
                     pathQueue.offer(newList);

                     Set<String> newVisited = new HashSet<>(visitedPoll);
                     newVisited.add(word);
                     visitedQueue.offer(newVisited);
                  }
               }
            }
         }
      }

      return new ArrayList<>(result);
   }

   private static Map<String, List<String>> getAdjacent(String beginWord, List<String> wordList) {
      Map<String, List<String>> mapping = new HashMap<>();
      for (String word : wordList) {
         if (areSimilar(beginWord, word)) {
            List<String> tmp = mapping.getOrDefault(beginWord, new ArrayList<>());
            tmp.add(word);
            mapping.put(beginWord, tmp);
         }
      }

      for (int i = 0; i < wordList.size(); i++) {
         String current = wordList.get(i);

         for (String word : wordList) {
            if (!current.equals(word) && areSimilar(current, word)) {
               List<String> tmp = mapping.getOrDefault(current, new ArrayList<>());
               tmp.add(word);
               mapping.put(current, tmp);
            }
         }
      }

      return mapping;
   }

   private static boolean areSimilar(String word1, String word2) {
      int amountOfDiff = 0;
      for (int i = 0; i < word1.length(); i++) {
         if (word1.charAt(i) != word2.charAt(i)) {
            amountOfDiff++;
         }

         if (amountOfDiff > 1) {
            return false;
         }
      }
      return true;
   }
}
