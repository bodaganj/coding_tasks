package com.coding.tasks.leetcode.top.interview.questions.hard.trees_and_graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

   public static void main(String[] args) {
      System.out.println(ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog")));
      System.out.println(ladderLength("a", "c", List.of("a", "b", "c")));
   }

   /**
    * N = wordList.size()
    * L = beginWord.length
    * <p>
    * Time complexity =
    * Space complexity =
    */
   private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
      if (!wordList.contains(endWord)) {
         return 0;
      }

      int counter = 1;
      Set<String> seen = new HashSet<>(); // S(N)

      Queue<String> queue = new LinkedList<>(); // S(N)   O(N)
      queue.add(beginWord);

      while (!queue.isEmpty()) {
         int size = queue.size();
         counter++;

         while (size-- > 0) {
            String poll = queue.poll();
            List<String> wordsWithOneCharDiff = getWordsWithOneCharDiff(poll, wordList, seen); // S(N)
            for (String s : wordsWithOneCharDiff) {
               if (s.equals(endWord)) {
                  return counter;
               }
               queue.add(s);
            }
         }
      }

      return 0;
   }

   private static List<String> getWordsWithOneCharDiff(String word, List<String> wordList, Set<String> seen) {
      List<String> res = new ArrayList<>();
      for (String s : wordList) {
         if (!seen.contains(s) && isOneCharDiff(s, word)) {
            res.add(s);
            seen.add(s);
         }
      }
      return res;
   }

   private static boolean isOneCharDiff(String word1, String word2) {
      int index = 0;
      int amountOfDiff = 0;

      while (index < word1.length()) {
         if (word1.charAt(index) != word2.charAt(index)) {
            amountOfDiff++;
         }
         if (amountOfDiff > 1) {
            return false;
         }
         index++;
      }

      return true;
   }
}
