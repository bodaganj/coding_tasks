package com.coding.tasks.leetcode.third_round.amazon.arrays.and.strings;

import java.util.Arrays;

public class ThreeSumClosest {

   public static void main(String[] args) {
      System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
      System.out.println(threeSumClosest(new int[]{0, 0, 0}, 1));
   }

   public static int threeSumClosest(int[] nums, int target) {
      Arrays.sort(nums);
      int minSum = Integer.MAX_VALUE;
      int dif = Integer.MAX_VALUE;
      for (int i = 0; i < nums.length - 2; i++) {
         int left = i + 1;
         int right = nums.length - 1;

         while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            if (dif > Math.abs(target - sum)) {
               dif = Math.abs(target - sum);
               minSum = sum;
            }
            if (sum < target) {
               left++;
            } else {
               right--;
            }
         }
      }
      return minSum;
   }
}
