package com.coding.tasks.leetcode.third_round.amazon.trees.and.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class WordLadderII {

   public static void main(String[] args) {
      System.out.println(findLadders("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog")));
//      System.out.println(findLadders("hot", "dog", List.of("hot", "dog")));
   }

   public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
      Set<List<String>> ans = new HashSet<>();

      if (!wordList.contains(endWord)) {
         return Collections.emptyList();
      }

      Map<String, Set<String>> oneLetterMapping = new HashMap<>();
      oneLetterMapping.put(beginWord, getOneLetterMapping(beginWord, wordList));
      for (String s : wordList) {
         oneLetterMapping.put(s, getOneLetterMapping(s, wordList));
      }

      int shortest = Integer.MAX_VALUE;
      Set<String> seen = new HashSet<>();
      Queue<String> wordsQueue = new LinkedList<>();
      wordsQueue.add(beginWord);
      Queue<List<String>> listQueue = new LinkedList<>();
      List<String> list = new ArrayList<>();
      list.add(beginWord);
      listQueue.add(list);

      while (!wordsQueue.isEmpty()) {
         int size = wordsQueue.size();
         while (size > 0) {
            String currentWord = wordsQueue.poll();
            seen.add(currentWord);
            List<String> currentList = listQueue.poll();

            if (currentWord.equals(endWord)) {
               shortest = Math.min(shortest, currentList.size());
               ans.add(currentList);
            } else {
               if (currentList.size() == shortest) {
                  break;
               }
               Set<String> strings = oneLetterMapping.getOrDefault(currentWord, Collections.emptySet());
               for (String string : strings) {
                  if (!seen.contains(string)) {
                     wordsQueue.add(string);
                     List<String> tmp = new ArrayList<>(currentList);
                     tmp.add(string);
                     listQueue.add(tmp);
                  }
               }
            }
            size--;
         }
      }

      int finalShortest = shortest;
      return ans.stream().filter(l -> l.size() == finalShortest).collect(Collectors.toList());
   }

   private static Set<String> getOneLetterMapping(String str, List<String> wordList) {
      Set<String> neighbors = new HashSet<>();
      char charList[] = str.toCharArray();

      for (int i = 0; i < str.length(); i++) {
         char oldChar = charList[i];

         // replace the i-th character with all letters from a to z except the original character
         for (char c = 'a'; c <= 'z'; c++) {
            charList[i] = c;

            // skip if the character is same as original or if the word is not present in the wordList
            if (c == oldChar || !wordList.contains(String.valueOf(charList))) {
               continue;
            }
            neighbors.add(String.valueOf(charList));
         }
         charList[i] = oldChar;
      }
      return neighbors;
   }
}
