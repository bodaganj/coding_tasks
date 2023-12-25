package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.sorting.and.searching;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {

   public int[] topKFrequent(int[] nums, int k) {
      Map<Integer, Integer> mapping = new HashMap<>();
      for (int num : nums) {
         mapping.put(num, mapping.getOrDefault(num, 0) + 1);
      }

      Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
      for (Map.Entry<Integer, Integer> entry : mapping.entrySet()) {
         queue.add(entry);
         while (queue.size() > k) {
            queue.poll();
         }
      }
      int[] ans = new int[k];
      for (int i = 0; i < k; i++) {
         ans[i] = queue.poll().getKey();
      }
      return ans;
   }
}
