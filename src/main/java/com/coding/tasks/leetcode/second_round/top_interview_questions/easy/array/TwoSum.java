package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

   public static void main(String[] args) {
      int[] twoSum1 = twoSum(new int[]{2, 7, 11, 15}, 9);
      int[] twoSum2 = twoSum(new int[]{3, 2, 4}, 6);
      int[] twoSum3 = twoSum(new int[]{3, 3}, 6);
      int[] twoSum4 = twoSum(new int[]{}, 6);
      int[] twoSum5 = twoSum(null, 6);

      for (int i : twoSum1) {
         System.out.print(i + " ");
      }
      System.out.println("-------");
      for (int i : twoSum2) {
         System.out.print(i + " ");
      }
      System.out.println("-------");
      for (int i : twoSum3) {
         System.out.print(i + " ");
      }
      System.out.println("-------");
      for (int i : twoSum4) {
         System.out.print(i + " ");
      }
      System.out.println("-------");
      for (int i : twoSum5) {
         System.out.print(i + " ");
      }
   }

   private static int[] twoSum(int[] nums, int target) {
      if (nums == null || nums.length == 0) {
         return new int[0];
      }
      Map<Integer, Integer> mapping = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
         if (mapping.containsKey(nums[i])) {
            return new int[]{i, mapping.get(nums[i])};
         } else {
            mapping.put(target - nums[i], i);
         }
      }
      return new int[0];
   }
}
