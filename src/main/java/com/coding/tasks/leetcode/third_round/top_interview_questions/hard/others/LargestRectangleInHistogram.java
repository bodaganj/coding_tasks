package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.others;

public class LargestRectangleInHistogram {

   public static void main(String[] args) {
      System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
   }

   public static int largestRectangleArea(int[] heights) {
      int max = 0;
      for (int i = 0; i < heights.length; i++) {
         max = Math.max(max, heights[i]);
         int currentMin = heights[i];
         for (int j = i + 1; j < heights.length; j++) {
            currentMin = Math.min(currentMin, heights[j]);
            max = Math.max(max, currentMin * (j - i + 1));
         }
      }
      return max;
   }
}