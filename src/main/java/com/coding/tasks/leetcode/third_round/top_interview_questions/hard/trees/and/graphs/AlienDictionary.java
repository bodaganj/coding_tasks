package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.trees.and.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AlienDictionary {

   public static void main(String[] args) {
      System.out.println(alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
      System.out.println(alienOrder(new String[]{"z", "x", "z"}));
      System.out.println(alienOrder(new String[]{"zy", "zx"}));
      System.out.println(alienOrder(new String[]{"abc", "ab"}));
      System.out.println(alienOrder(new String[]{"c", "b", "ac", "aa"}));
   }

   public static String alienOrder(String[] words) {
      StringBuilder sb = new StringBuilder();
      Set<Character> uniqueChars = getUniqueChars(words);

      Map<Character, Set<Character>> firstLettersMapping = getFirstLettersMapping(words);
      Map<Character, Set<Character>> mapping = new HashMap<>(firstLettersMapping);
      Map<Character, Set<Character>> similarWordsMapping = getSimilarWordsMapping(words);
      if (similarWordsMapping.containsKey('$')) {
         return "";
      }

      for (Map.Entry<Character, Set<Character>> entry : similarWordsMapping.entrySet()) {
         if (mapping.containsKey(entry.getKey())) {
            mapping.get(entry.getKey()).addAll(entry.getValue());
         } else {
            mapping.put(entry.getKey(), entry.getValue());
         }
      }

      Queue<Character> queue = new LinkedList<>();
      for (Map.Entry<Character, Set<Character>> entry : mapping.entrySet()) {
         if (entry.getValue().isEmpty()) {
            queue.add(entry.getKey());
         }
      }
      for (Character uniqueChar : uniqueChars) {
         if (!mapping.containsKey(uniqueChar)) {
            queue.add(uniqueChar);
         }
      }

      while (!queue.isEmpty()) {
         Character poll = queue.poll();
         sb.append(poll);

         for (Map.Entry<Character, Set<Character>> entry : mapping.entrySet()) {
            Set<Character> value = entry.getValue();
            if (value.contains(poll)) {
               if (value.size() == 1) {
                  queue.add(entry.getKey());
               } else {
                  value.remove(poll);
               }
            }
         }
      }

      return uniqueChars.size() == sb.length() ? sb.toString() : "";
   }

   private static Set<Character> getUniqueChars(String[] words) {
      Set<Character> unique = new HashSet<>();
      for (String word : words) {
         for (char c : word.toCharArray()) {
            unique.add(c);
         }
      }
      return unique;
   }

   private static Map<Character, Set<Character>> getFirstLettersMapping(String[] words) {
      Set<Character> prevLetters = new HashSet<>();
      Map<Character, Set<Character>> mapping = new HashMap<>();
      for (String word : words) {
         char charAt = word.charAt(0);
         mapping.put(charAt, new HashSet<>(prevLetters));
         prevLetters.add(charAt);
      }
      for (Map.Entry<Character, Set<Character>> entry : mapping.entrySet()) {
         entry.getValue().remove(entry.getKey());
      }

      return mapping;
   }

   private static Map<Character, Set<Character>> getSimilarWordsMapping(String[] words) {
      Map<Character, Set<Character>> mapping = new HashMap<>();
      for (int i = 0; i < words.length; i++) {
         for (int j = i + 1; j < words.length; j++) {
            int index = 0;
            while (index < words[i].length() && index < words[j].length() && words[i].charAt(index) == words[j].charAt(index)) {
               index++;
               if (index == words[j].length() && index < words[i].length()) {
                  return Map.of('$', Set.of());
               }
            }
            if (index != 0 && index < words[j].length() && index < words[i].length()) {
               Set<Character> list = mapping.getOrDefault(words[j].charAt(index), new HashSet<>());
               list.add(words[i].charAt(index));
               mapping.put(words[j].charAt(index), list);
            }
         }
      }
      return mapping;
   }
}
