package com.coding.tasks.leetcode.amazon.sorting_and_searching;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {

   public static void main(String[] args) {
      System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
   }

   private static int[] topKFrequent(int[] nums, int k) {
      Map<Integer, Integer> mapping = new HashMap<>();
      for (int num : nums) {
         mapping.put(num, mapping.getOrDefault(num, 0) + 1);
      }

      Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

      for (Map.Entry<Integer, Integer> integerIntegerEntry : mapping.entrySet()) {
         queue.offer(integerIntegerEntry);

         if (queue.size() > k) {
            queue.poll();
         }
      }

      int[] ans = new int[queue.size()];
      for (int i = 0; i < ans.length; i++) {
         ans[i] = queue.poll().getKey();
      }

      return ans;
   }
}
