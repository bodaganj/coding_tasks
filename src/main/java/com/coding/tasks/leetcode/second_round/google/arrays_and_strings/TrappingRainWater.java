package com.coding.tasks.leetcode.second_round.google.arrays_and_strings;

import java.util.Arrays;

public class TrappingRainWater {

   public static void main(String[] args) {
      System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
      System.out.println(trap(new int[]{4, 2, 0, 3, 2, 5}));
   }

   private static int trap(int[] height) {
      int max = height[0];
      int[] arr = new int[height.length];
      arr[0] = 0;

      for (int i = 1; i < height.length; i++) {
         if (height[i] <= max) {
            arr[i] = max - height[i];
         } else {
            max = height[i];
         }
      }

      max = height[height.length - 1];
      arr[arr.length - 1] = 0;
      for (int i = height.length - 2; i >= 0; i--) {
         if (height[i] <= max) {
            arr[i] = Math.min(arr[i], max - height[i]);
         } else {
            arr[i] = 0;
            max = height[i];
         }
      }

      return Arrays.stream(arr).sum();
   }
}
