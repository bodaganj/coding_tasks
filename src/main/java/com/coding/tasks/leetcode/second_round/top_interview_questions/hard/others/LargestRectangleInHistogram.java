package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.others;

import java.util.Arrays;

public class LargestRectangleInHistogram {

   public static void main(String[] args) {
      System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
      System.out.println(largestRectangleArea(new int[]{2, 1, 2, 1}));
   }

   private static int largestRectangleArea(int[] heights) {
      int[] dp = new int[heights.length];
      dp[0] = heights[0];

      for (int i = 1; i < heights.length; i++) {
         int prevMax = 0;
         int currMin = heights[i];

//         if (heights[i] == heights[i - 1]) {
//            dp[i] = dp[i - 1] + ;
//         } else {
         for (int j = i - 1; j >= 0; j--) {
            currMin = Math.min(currMin, heights[j]);
            prevMax = Math.max(prevMax, currMin * (i - j + 1));
         }
         dp[i] = Math.max(heights[i], prevMax);
//         }
      }

      return Arrays.stream(dp).max().getAsInt();
   }
}
