package com.coding.tasks.leetcode.second_round.google.trees_and_graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

   public static void main(String[] args) {
      System.out.println(ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog")));
//      System.out.println(ladderLength("a", "c", List.of("a", "b", "c")));
   }

   private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
      int count = 1;
      Set<String> visited = new HashSet<>();
      Queue<String> queue = new LinkedList<>();
      queue.offer(beginWord);

      while (!queue.isEmpty()) {
         int size = queue.size();

         while (size > 0) {
            size--;
            String poll = queue.poll();

            if (poll.equals(endWord)) {
               return count;
            }

            for (String s : wordList) {
               if (!visited.contains(s) && areSimilarWords(s, poll)) {
                  visited.add(s);
                  queue.offer(s);
               }
            }
         }

         count++;
      }

      return 0;
   }

   private static boolean areSimilarWords(String first, String second) {
      int counter = 0;
      int dif = 0;
      while (counter < first.length()) {
         if (first.charAt(counter) != second.charAt(counter)) {
            dif++;
         }
         if (dif > 1) {
            return false;
         }
         counter++;
      }

      return true;
   }
}
