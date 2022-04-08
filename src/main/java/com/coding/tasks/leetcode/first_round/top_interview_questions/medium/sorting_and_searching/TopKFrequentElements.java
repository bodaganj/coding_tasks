package com.coding.tasks.leetcode.first_round.top_interview_questions.medium.sorting_and_searching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {

   public static void main(String[] args) {
      System.out.println(Arrays.toString(topKFrequent(new int[]{3, 0, 1, 0}, 1)));
      System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3, 2, 1, 1}, 2)));
   }

   private static int[] topKFrequent(int[] nums, int k) {
      Queue<Counter> queue = new PriorityQueue<>((a, b) -> Integer.compare(b.count, a.count));
      Map<Integer, Integer> mapping = new HashMap<>();

      for (int num : nums) {
         mapping.put(num, mapping.getOrDefault(num, 0) + 1);
      }

      for (Map.Entry<Integer, Integer> integerIntegerEntry : mapping.entrySet()) {
         queue.offer(new Counter(integerIntegerEntry.getKey(), integerIntegerEntry.getValue()));
      }

      int[] ans = new int[k];
      for (int i = 0; i < k; i++) {
         ans[i] = queue.poll().value;
      }
      return ans;
   }

   // Should not be used!!!
   static class Counter {

      public int value;
      public int count;

      public Counter(int value, int count) {
         this.value = value;
         this.count = count;
      }
   }
}
