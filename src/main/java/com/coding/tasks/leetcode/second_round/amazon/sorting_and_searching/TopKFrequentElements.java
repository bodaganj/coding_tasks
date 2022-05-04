package com.coding.tasks.leetcode.second_round.amazon.sorting_and_searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {

   public static void main(String[] args) {
      System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
   }

   private static int[] topKFrequent(int[] nums, int k) {
      Map<Integer, Integer> map = new HashMap<>();
      for (int num : nums) {
         map.put(num, map.getOrDefault(num, 0) + 1);
      }

      Queue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> map.get(a)));
      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
         pq.offer(entry.getKey());
         if (pq.size() > k) {
            pq.poll();
         }
      }

      List<Integer> tmp = new ArrayList<>();
      while (!pq.isEmpty()) {
         tmp.add(pq.poll());
      }
      return tmp.stream().mapToInt(Integer::intValue).toArray();
   }
}
