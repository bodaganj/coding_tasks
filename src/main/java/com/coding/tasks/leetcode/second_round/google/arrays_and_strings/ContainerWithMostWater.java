package com.coding.tasks.leetcode.second_round.google.arrays_and_strings;

public class ContainerWithMostWater {

   public static void main(String[] args) {
      System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
      System.out.println(maxArea(new int[]{1, 1}));
      System.out.println(maxArea(new int[]{4, 3, 2, 1, 4}));
      System.out.println(maxArea(new int[]{1, 2, 1}));
   }

   private static int maxArea(int[] height) {
      int max = 0;

      int left = 0;
      int right = height.length - 1;
      while (left < right) {
         max = Math.max(max, Math.min(height[right], height[left]) * (right - left));

         if (height[left] < height[right]) {
            left++;
         } else {
            right--;
         }
      }

      return max;
   }
}
