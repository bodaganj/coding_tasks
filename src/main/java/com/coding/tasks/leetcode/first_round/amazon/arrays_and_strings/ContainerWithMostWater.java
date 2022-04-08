package com.coding.tasks.leetcode.first_round.amazon.arrays_and_strings;

import java.util.Objects;

public class ContainerWithMostWater {

   public static void main(String[] args) {
      System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
   }

   private static int maxArea(int[] height) {
      int result = 0;

      if (!Objects.isNull(height) && height.length > 1) {
         int i = 0;
         int j = height.length - 1;

         while (i < j) {
            result = Math.max(result, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
               i++;
            } else {
               j--;
            }
         }
      }
      return result;
   }
}
