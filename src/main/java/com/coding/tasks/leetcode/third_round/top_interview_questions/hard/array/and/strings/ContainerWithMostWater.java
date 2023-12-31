package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.array.and.strings;

public class ContainerWithMostWater {

   public int maxArea(int[] height) {
      int left = 0;
      int right = height.length - 1;
      int max = 0;
      while (left < right) {
         max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
         if (height[left] < height[right]) {
            left++;
         } else {
            right--;
         }
      }
      return max;
   }
}
