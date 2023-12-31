package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.others;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {

   public static void main(String[] args) {
      System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B'}, 2));
      System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
      System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0));
   }

   public static int leastInterval(char[] tasks, int n) {
      if (n == 0) {
         return tasks.length;
      }

      Map<Character, Integer> mapping = new HashMap<>();
      for (char task : tasks) {
         mapping.put(task, mapping.getOrDefault(task, 0) + 1);
      }

      Map<Character, Integer> lastTaskIndex = new HashMap<>();
      Queue<Character> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(mapping::get).reversed());

      for (Map.Entry<Character, Integer> entry : mapping.entrySet()) {
         priorityQueue.add(entry.getKey());
      }

      List<Character> ans = new ArrayList<>();
      while (!mapping.isEmpty()) {
         Character next = null;
         List<Character> tmp = new ArrayList<>();
         while (next == null && !priorityQueue.isEmpty()) {
            Character poll = priorityQueue.poll();
            if (lastTaskIndex.containsKey(poll) && ans.size() - lastTaskIndex.get(poll) <= n) {
               tmp.add(poll);
            } else {
               next = poll;
            }
         }
         priorityQueue.addAll(tmp);
         if (next != null) {
            lastTaskIndex.put(next, ans.size());
            ans.add(next);
            if (mapping.get(next) == 1) {
               mapping.remove(next);
            } else {
               mapping.put(next, mapping.get(next) - 1);
               priorityQueue.add(next);
            }
         } else {
            ans.add('#');
         }
      }
      return ans.size();
   }
}
