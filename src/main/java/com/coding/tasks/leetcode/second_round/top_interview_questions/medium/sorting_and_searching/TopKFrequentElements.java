package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.sorting_and_searching;

import java.util.Arrays;
import java.util.Comparator;
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
      Map<Integer, Integer> mapping = new HashMap<>();
      for (int num : nums) {
         mapping.put(num, mapping.getOrDefault(num, 0) + 1);
      }

      Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
      for (Map.Entry<Integer, Integer> entry : mapping.entrySet()) {
         queue.offer(entry);
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
