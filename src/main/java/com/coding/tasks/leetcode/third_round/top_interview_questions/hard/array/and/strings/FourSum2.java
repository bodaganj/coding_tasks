package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.array.and.strings;

import java.util.HashMap;
import java.util.Map;

public class FourSum2 {

   public static void main(String[] args) {
      System.out.println(fourSumCount(new int[]{-1, -1}, new int[]{-1, 1}, new int[]{-1, 1}, new int[]{1, -1}));
   }

   public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
      Map<Integer, Integer> mappingFirstSecond = new HashMap<>();
      for (int i : nums1) {
         for (int i1 : nums2) {
            int key = -1 * (i + i1);
            mappingFirstSecond.put(key, mappingFirstSecond.getOrDefault(key, 0) + 1);
         }
      }

      int counter = 0;
      for (int i : nums3) {
         for (int i1 : nums4) {
            int expectedKey = i + i1;
            if (mappingFirstSecond.containsKey(expectedKey)) {
               counter += mappingFirstSecond.get(expectedKey);
            }
         }
      }

      return counter;
   }
}
