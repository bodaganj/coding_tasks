package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.others;

import java.util.Arrays;

public class TrappingRainWater {

   public static void main(String[] args) {
      System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
   }

   public static int trap(int[] height) {
      int[] ans = new int[height.length];
      int max = height[0];
      for (int i = 1; i < height.length; i++) {
         if (max <= height[i]) {
            max = Math.max(max, height[i]);
         } else {
            ans[i] = max - height[i];
         }
      }

      ans[ans.length - 1] = 0;
      max = height[height.length - 1];
      for (int i = height.length - 2; i >= 0; i--) {
         if (max <= height[i]) {
            max = Math.max(max, height[i]);
            ans[i] = 0;
         } else {
            ans[i] = Math.min(ans[i], max - height[i]);
         }
      }

      return Arrays.stream(ans).sum();
   }
}
