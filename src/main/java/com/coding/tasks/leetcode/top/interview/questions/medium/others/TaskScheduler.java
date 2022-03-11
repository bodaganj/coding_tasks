package com.coding.tasks.leetcode.top.interview.questions.medium.others;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TaskScheduler {

   public static void main(String[] args) {
      System.out.println(leastInterval(new char[]{'a', 'a', 'a', 'b', 'b', 'b'}, 2));
      System.out.println(leastInterval(new char[]{'a', 'a', 'a', 'b', 'b', 'b'}, 0));
   }

   private static int leastInterval(char[] tasks, int n) {
      Map<Character, Integer> waiting = new HashMap<>();
      Map<Character, Integer> intervals = new HashMap<>();

      // registering all the tasks which should be executed
      for (char task : tasks) {
         intervals.put(task, intervals.getOrDefault(task, 0) + 1);
      }

      int count = 0;

      // while all the tasks are not executed
      while (!intervals.isEmpty()) {
         // get the list of tasks sorted by amount (the more we have the lower index within the list)
         List<Map.Entry<Character, Integer>> maxToBeUsed = getMaxToBeUsed(intervals);
         boolean isAdded = false;

         // find proper entry (if we got the entry we can use, break the loop)
         for (Map.Entry<Character, Integer> entry : maxToBeUsed) {
            // if waiting list doesn't contain the entry or the waiting list is empty - this is proper entry
            if (waiting.isEmpty() || !waiting.containsKey(entry.getKey())) {
               // decreasing the amount of tasks to be added for current entry
               intervals.put(entry.getKey(), intervals.get(entry.getKey()) - 1);
               intervals.entrySet().removeIf(e -> e.getValue() == 0);

               // updating waiting list
               waiting.replaceAll((k, v) -> v - 1);
               waiting.entrySet().removeIf(e -> e.getValue() == 0);

               // add current entry to waiting list
               if (n != 0) {
                  waiting.put(entry.getKey(), n);
               }

               count++;
               isAdded = true;
               break;
            }
         }

         // if we don't have entry to add, skip round
         if (!isAdded) {
            count++;
            waiting.replaceAll((k, v) -> v - 1);
            waiting.entrySet().removeIf(e -> e.getValue() == 0);
         }
      }

      return count;
   }

   private static List<Map.Entry<Character, Integer>> getMaxToBeUsed(Map<Character, Integer> intervals) {
      return intervals.entrySet().stream().sorted(Comparator.comparingInt(entry -> -entry.getValue())).collect(Collectors.toList());
   }
}
