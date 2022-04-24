package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.trees_and_graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AlienDictionary {

   public static void main(String[] args) {
      System.out.println(alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
      System.out.println(alienOrder(new String[]{"zy", "zx"}));
      System.out.println(alienOrder(new String[]{"ab", "adc"}));
      System.out.println(alienOrder(new String[]{"abc", "ab"}));
      System.out.println(alienOrder(new String[]{"vlxpwiqbsg", "cpwqwqcd"}));
   }

   private static String alienOrder(String[] words) {
      if (words.length == 1) {
         return getDistinctChars(words[0]);
      }
      Map<Character, Set<Character>> dependencies = getDependenciesMapping(words);
      if (dependencies == null) {
         return "";
      }

      StringBuilder sb = new StringBuilder();

      Set<Character> visited = new HashSet<>();
      Queue<Character> queue = new LinkedList<>();
      for (Map.Entry<Character, Set<Character>> entry : dependencies.entrySet()) {
         if (entry.getValue().isEmpty()) {
            queue.offer(entry.getKey());
            visited.add(entry.getKey());
         }
      }

      while (!queue.isEmpty()) {
         int size = queue.size();
         while (size > 0) {
            size--;

            Character poll = queue.poll();
            sb.append(poll);
            dependencies.remove(poll);

            for (Map.Entry<Character, Set<Character>> entry : dependencies.entrySet()) {
               entry.getValue().remove(poll);
            }

            List<Character> emptyChars = new ArrayList<>();
            for (Map.Entry<Character, Set<Character>> entry : dependencies.entrySet()) {
               if (entry.getValue().isEmpty()) {
                  emptyChars.add(entry.getKey());
               }
            }

            for (Character emptyChar : emptyChars) {
               if (!visited.contains(emptyChar)) {
                  queue.offer(emptyChar);
                  visited.add(emptyChar);
               }
            }
         }
      }

      return dependencies.isEmpty() ? sb.toString() : "";
   }

   private static Map<Character, Set<Character>> getDependenciesMapping(String[] words) {
      Map<Character, Set<Character>> dependencies = new HashMap<>();
      for (int i = 0; i < words.length; i++) {
         String current = words[i];
         for (int j = i + 1; j < words.length; j++) {
            String wordToCompare = words[j];
            int counter = 0;
            while (counter < current.length() && counter < words[j].length()) {
               if (!dependencies.containsKey(current.charAt(counter))) {
                  dependencies.put(current.charAt(counter), new HashSet<>());
               }
               if (!dependencies.containsKey(wordToCompare.charAt(counter))) {
                  dependencies.put(wordToCompare.charAt(counter), new HashSet<>());
               }

               if (current.charAt(counter) != wordToCompare.charAt(counter)) {
                  Set<Character> characters = dependencies.get(wordToCompare.charAt(counter));
                  characters.add(current.charAt(counter));
                  dependencies.put(wordToCompare.charAt(counter), characters);
                  break;
               }

               counter++;
            }

            if (counter == wordToCompare.length() && counter < current.length()) {
               return null;
            }

            int counterCurrent = counter;
            while (counterCurrent < current.length()) {
               if (!dependencies.containsKey(current.charAt(counterCurrent))) {
                  dependencies.put(current.charAt(counterCurrent), new HashSet<>());
               }
               counterCurrent++;
            }

            while (counter < wordToCompare.length()) {
               if (!dependencies.containsKey(wordToCompare.charAt(counter))) {
                  dependencies.put(wordToCompare.charAt(counter), new HashSet<>());
               }
               counter++;
            }
         }
      }
      return dependencies;
   }

   private static String getDistinctChars(String word) {
      Set<Character> set = new HashSet<>();
      for (char c : word.toCharArray()) {
         set.add(c);
      }
      StringBuilder sb = new StringBuilder();
      for (Character character : set) {
         sb.append(character);
      }

      return sb.toString();
   }
}
