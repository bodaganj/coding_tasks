package com.coding.tasks.leetcode.amazon.trees_and_graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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

      Queue<String> queue = new LinkedList<>();
      queue.offer(beginWord);

      Queue<List<String>> pathQueue = new LinkedList<>();
      pathQueue.offer(List.of(beginWord));

      Queue<Set<String>> visitedQueue = new LinkedList<>();
      visitedQueue.offer(Set.of(beginWord));

      while (!queue.isEmpty()) {
         String poll = queue.poll();
         List<String> pathPoll = pathQueue.poll();
         Set<String> visitedPoll = visitedQueue.poll();

         if (pathPoll.size() >= amountOfWords) {
            continue;
         }

         for (String word : getAdjacent(poll, wordList, visitedPoll)) {
            List<String> newList = new ArrayList<>(pathPoll);
            newList.add(word);

            if (word.equals(endWord)) {
               if (newList.size() < amountOfWords) {
                  amountOfWords = newList.size();
                  result = new HashSet<>();
                  result.add(newList);
               } else if (newList.size() == amountOfWords) {
                  result.add(newList);
               }
            } else {
               if (newList.size() < amountOfWords) {
                  queue.offer(word);

                  pathQueue.offer(newList);

                  Set<String> newVisited = new HashSet<>(visitedPoll);
                  newVisited.add(word);
                  visitedQueue.offer(newVisited);
               }
            }
         }
      }

      return new ArrayList<>(result);
   }

   private static List<String> getAdjacent(String str, List<String> wordList, Set<String> visited) {
      List<String> list = new ArrayList<>();
      for (String word : wordList) {
         if (!visited.contains(word) && !str.equals(word)) {
            if (areSimilar(str, word)) {
               list.add(word);
            }
         }
      }

      return list;
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
