package com.coding.tasks.leetcode.second_round.amazon.arrays_and_strings;

import java.util.TreeMap;

public class ThreeSumClosest {

   public static void main(String[] args) {
      System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
      System.out.println(threeSumClosest(new int[]{0, 0, 0}, 1));
      System.out.println(threeSumClosest(new int[]{0, 2, 1, -3}, 1));
   }

   private static int threeSumClosest(int[] nums, int target) {
      int minSum = Integer.MAX_VALUE;
      int minDif = Integer.MAX_VALUE;
      for (int i = 0; i < nums.length; i++) {
         TreeMap<Integer, Integer> map = new TreeMap<>();
         for (int j = i + 1; j < nums.length; j++) {
            if (map.floorKey(nums[j]) != null) {
               int currentSum = nums[i] + nums[j] + nums[map.get(map.floorKey(nums[j]))];
               int currentDif = Math.abs(target - currentSum);
               if (minDif > currentDif) {
                  minDif = currentDif;
                  minSum = currentSum;
               }
            }
            if (map.ceilingKey(nums[j]) != null) {
               int currentSum = nums[i] + nums[j] + nums[map.get(map.ceilingKey(nums[j]))];
               int currentDif = Math.abs(target - currentSum);
               if (minDif > currentDif) {
                  minDif = currentDif;
                  minSum = currentSum;
               }
            }
            map.put(target - nums[i] - nums[j], j);
         }
      }

      return minSum;
   }
}
