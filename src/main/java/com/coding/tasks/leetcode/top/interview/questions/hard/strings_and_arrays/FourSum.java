package com.coding.tasks.leetcode.top.interview.questions.hard.strings_and_arrays;

import java.util.HashMap;
import java.util.Map;

public class FourSum {

   public static void main(String[] args) {
      System.out.println(fourSumCount(new int[]{-1, -1}, new int[]{-1, 1}, new int[]{-1, 1}, new int[]{1, -1}));
   }

   private static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
      Map<Integer, Integer> map1 = new HashMap<>();
      for (int i : nums1) {
         for (int j : nums2) {
            map1.put(i + j, map1.getOrDefault(i + j, 0) + 1);
         }
      }

      Map<Integer, Integer> map2 = new HashMap<>();
      for (int i : nums3) {
         for (int j : nums4) {
            int sum = -1 * (i + j);
            map2.put(sum, map2.getOrDefault(sum, 0) + 1);
         }
      }

      int counter = 0;

      if (map1.size() > map2.size()) {
         for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
            if (map1.containsKey(entry.getKey())) {
               counter += map1.get(entry.getKey()) * entry.getValue();
            }
         }
      } else {
         for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey())) {
               counter += map2.get(entry.getKey()) * entry.getValue();
            }
         }
      }
      return counter;
   }
}
