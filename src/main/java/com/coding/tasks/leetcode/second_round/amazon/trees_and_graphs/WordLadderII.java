package com.coding.tasks.leetcode.second_round.amazon.trees_and_graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {

   public static void main(String[] args) {
      System.out.println(findLadders("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog")));
      System.out.println(findLadders("a", "c", List.of("a", "b", "c")));
   }

   private static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
      List<List<String>> ans = new ArrayList<>();

      Map<String, List<String>> mapping = getMapping(beginWord, wordList);
      if (!mapping.containsKey(endWord)) {
         return ans;
      }
      Set<String> visited = new HashSet<>();

      Queue<String> queueWords = new LinkedList<>();
      queueWords.offer(beginWord);

      Queue<List<String>> queuePath = new LinkedList<>();
      List<String> path = new ArrayList<>();
      path.add(beginWord);
      queuePath.offer(path);

      while (!queueWords.isEmpty()) {
         int size = queueWords.size();
         while (size > 0) {
            String wordPoll = queueWords.poll();
            List<String> pathPoll = queuePath.poll();
            visited.add(wordPoll);

            if (wordPoll.equals(endWord)) {
               ans.add(pathPoll);
            } else {
               for (String s : mapping.get(wordPoll)) {
                  if (!visited.contains(s)) {
                     queueWords.offer(s);

                     List<String> tmp = new ArrayList<>(pathPoll);
                     tmp.add(s);
                     queuePath.offer(tmp);
                  }
               }
            }

            size--;
         }

         if (!ans.isEmpty()) {
            return ans;
         }
      }

      return ans;
   }

   private static Map<String, List<String>> getMapping(String beginWord, List<String> wordList) {
      Map<String, List<String>> mapping = new HashMap<>();

      Set<String> set = new HashSet<>(wordList);
      set.add(beginWord);

      for (String elem1 : set) {
         for (String elem2 : set) {
            if (!elem1.equals(elem2) && areSimilar(elem1, elem2)) {
               List<String> tmp = mapping.getOrDefault(elem1, new ArrayList<>());
               tmp.add(elem2);
               mapping.put(elem1, tmp);
            }
         }
      }

      return mapping;
   }

   private static boolean areSimilar(String str1, String str2) {
      int dif = 0;
      for (int i = 0; i < str1.length(); i++) {
         if (str1.charAt(i) != str2.charAt(i)) {
            dif++;
         }
         if (dif > 1) {
            return false;
         }
      }
      return true;
   }
}
