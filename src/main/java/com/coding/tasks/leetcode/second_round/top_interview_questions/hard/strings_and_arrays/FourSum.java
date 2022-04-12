package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.strings_and_arrays;

import java.util.HashMap;
import java.util.Map;

public class FourSum {

   public static void main(String[] args) {
      System.out.println(fourSumCount(new int[]{-1, -1}, new int[]{-1, 1}, new int[]{-1, 1}, new int[]{1, -1}));
   }

   private static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
      int length = nums1.length;
      Map<Integer, Integer> firstMapping = new HashMap<>();
      Map<Integer, Integer> secondMapping = new HashMap<>();

      for (int i = 0; i < length; i++) {
         for (int j = 0; j < length; j++) {
            int sum1 = nums1[i] + nums2[j];
            firstMapping.put(sum1, firstMapping.getOrDefault(sum1, 0) + 1);

            int sum2 = nums3[i] + nums4[j];
            secondMapping.put(sum2, secondMapping.getOrDefault(sum2, 0) + 1);
         }
      }

      int counter = 0;
      for (Map.Entry<Integer, Integer> entry : firstMapping.entrySet()) {
         int expectedKey = entry.getKey() * -1;
         if (secondMapping.containsKey(expectedKey)) {
            counter += entry.getValue() * secondMapping.get(expectedKey);
         }
      }

      return counter;
   }
}
