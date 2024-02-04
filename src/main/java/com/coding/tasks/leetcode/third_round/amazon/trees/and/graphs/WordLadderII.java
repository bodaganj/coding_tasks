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
      System.out.println(findLadders("hot", "dog", List.of("hot", "dog")));
   }

   public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
      Set<List<String>> ans = new HashSet<>();

      if (!wordList.contains(endWord)) {
         return Collections.emptyList();
      }

      Map<String, Set<String>> oneLetterMapping = new HashMap<>();
      getOneLetterMapping(beginWord, wordList, oneLetterMapping);
      for (String s : wordList) {
         getOneLetterMapping(s, wordList, oneLetterMapping);
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

   private static void getOneLetterMapping(String str, List<String> wordList, Map<String, Set<String>> oneLetterMapping) {
      for (String s : wordList) {
         if (!oneLetterMapping.containsKey(str) || !oneLetterMapping.containsKey(s) || !oneLetterMapping.get(s).contains(str)) {
            if (isOneLetterDif(s, str)) {
               Set<String> list1 = oneLetterMapping.getOrDefault(str, new HashSet<>());
               list1.add(s);
               oneLetterMapping.put(str, list1);

               Set<String> list2 = oneLetterMapping.getOrDefault(s, new HashSet<>());
               list2.add(str);
               oneLetterMapping.put(s, list2);
            }
         }
      }
   }

   private static boolean isOneLetterDif(String str1, String str2) {
      int count = 0;

      int index = 0;
      while (index < str1.length()) {
         if (count == 2) {
            return false;
         }
         if (str1.charAt(index) != str2.charAt(index)) {
            count++;
         }
         index++;
      }

      return count == 1;
   }
}
