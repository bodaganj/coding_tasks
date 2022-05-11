package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.others;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class TaskScheduler {

   public static void main(String[] args) {
      System.out.println(leastInterval(new char[]{'a', 'a', 'a', 'b', 'b', 'b'}, 2));
      System.out.println(leastInterval(new char[]{'a', 'a', 'a', 'b', 'b', 'b'}, 0));
      System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2));
   }

   private static int leastInterval(char[] tasks, int n) {
      Map<Character, Integer> charToIdleCounterMapper = new HashMap<>();
      Map<Character, Integer> charAmountMapper = getCharAmountMapping(tasks);

      int counter = 0;
      while (!charAmountMapper.isEmpty()) {
         counter++;

         // get char with max occurrences which has no idle time for now
         Optional<Map.Entry<Character, Integer>> max = charAmountMapper.entrySet()
                                                                       .stream()
                                                                       .filter(entry -> !charToIdleCounterMapper.containsKey(entry.getKey()))
                                                                       .max(Map.Entry.comparingByValue());

         if (max.isEmpty()) {
            decreaseIdleTime(charToIdleCounterMapper);
            continue;
         }

         Character aChar = max.get().getKey();
         decreaseIdleTime(charToIdleCounterMapper);

         // add last one
         charToIdleCounterMapper.put(aChar, n);

         int newAmount = charAmountMapper.get(aChar) - 1;
         if (newAmount > 0) {
            charAmountMapper.put(aChar, newAmount);
         } else {
            charAmountMapper.remove(aChar);
         }
      }

      return counter;
   }

   private static void decreaseIdleTime(Map<Character, Integer> charToIdleCounterMapper) {
      Set<Character> toRemove = new HashSet<>();
      for (Map.Entry<Character, Integer> entry : charToIdleCounterMapper.entrySet()) {
         int idle = entry.getValue() - 1;
         if (idle > 0) {
            charToIdleCounterMapper.put(entry.getKey(), idle);
         } else {
            toRemove.add(entry.getKey());
         }
      }

      for (Character character : toRemove) {
         charToIdleCounterMapper.remove(character);
      }
   }

   private static Map<Character, Integer> getCharAmountMapping(char[] tasks) {
      Map<Character, Integer> charAmountMapper = new HashMap<>();
      for (char task : tasks) {
         charAmountMapper.put(task, charAmountMapper.getOrDefault(task, 0) + 1);
      }

      return charAmountMapper;
   }
}
