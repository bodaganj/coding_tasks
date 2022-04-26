package com.coding.tasks.leetcode.second_round.amazon.trees_and_graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class WordLadderII {

   public static void main(String[] args) {
      System.out.println(findLadders("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog")));
   }

   private static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
      List<List<String>> ans = new ArrayList<>();
      int maxLength = Integer.MAX_VALUE;

      Map<String, List<String>> mapping = getMapping(beginWord, wordList);
      if (!mapping.containsKey(endWord)) {
         return ans;
      }

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

            if (wordPoll.equals(endWord)) {
               if (pathPoll.size() < maxLength) {
                  maxLength = pathPoll.size();
                  ans = new ArrayList<>();
               }
               ans.add(pathPoll);
            } else {
               for (String s : wordList) {
                  if (!s.equals(wordPoll) && areSimilar(wordPoll, s)) {
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

      List<String> beginSimilar = new ArrayList<>();
      for (String s : wordList) {
         if (areSimilar(beginWord, s)) {
            beginSimilar.add(s);
         }
      }
      mapping.put(beginWord, beginSimilar);

      for (int i = 0; i < wordList.size(); i++) {
         for (int j = i + 1; j < wordList.size(); j++) {
            String first = wordList.get(i);
            String second = wordList.get(j);

            if (areSimilar(first, second)) {
               List<String> tmp1 = mapping.getOrDefault(first, new ArrayList<>());
               tmp1.add(second);
               mapping.put(first, tmp1);

               List<String> tmp2 = mapping.getOrDefault(second, new ArrayList<>());
               tmp2.add(first);
               mapping.put(second, tmp2);
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
