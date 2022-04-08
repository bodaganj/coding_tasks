package com.coding.tasks.leetcode.first_round.top_interview_questions.easy.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TwoSum {

   /**
    * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    * You may assume that each input would have exactly one solution, and you may not use the same element twice.
    * You can return the answer in any order.
    * @param args
    */
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
      if (Objects.isNull(nums)) {
         return new int[]{};
      }
      Map<Integer, Integer> expectedIntegerToIndexMapping = new HashMap<>();

      for (int index = 0; index < nums.length; index++) {
         int potentialExpectedInteger = target - nums[index];
         if (expectedIntegerToIndexMapping.containsKey(nums[index])) {
            return new int[]{index, expectedIntegerToIndexMapping.get(nums[index])};
         } else {
            expectedIntegerToIndexMapping.put(potentialExpectedInteger, index);
         }
      }
      return new int[]{};
   }
}
