package com.coding.tasks.leetcode.first_round.amazon.arrays_and_strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

   public static void main(String[] args) {
      System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
      System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
      System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
   }

   private static int[] twoSum(int[] nums, int target) {
      Map<Integer, Integer> map = new HashMap<>();

      for (int i = 0; i < nums.length; i++) {
         if (map.containsKey(nums[i])) {
            return new int[]{i, map.get(nums[i])};
         } else {
            map.put(target - nums[i], i);
         }
      }
      return new int[]{};
   }
}
