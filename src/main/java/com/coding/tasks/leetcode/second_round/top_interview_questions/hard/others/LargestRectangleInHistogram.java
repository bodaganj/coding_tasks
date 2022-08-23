package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.others;

import java.util.Stack;

public class LargestRectangleInHistogram {

   public static void main(String[] args) {
      System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
      System.out.println(largestRectangleArea(new int[]{2, 1, 2, 1}));
   }

   private static int largestRectangleArea(int[] heights) {
      Stack<Integer> stack = new Stack<>();
      stack.push(-1);

      int maxArea = 0;
      for (int i = 0; i < heights.length; i++) {
         while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
            int currentHeight = heights[stack.pop()];
            int currentWidth = i - stack.peek() - 1;
            maxArea = Math.max(maxArea, currentHeight * currentWidth);
         }
         stack.push(i);
      }
      while (stack.peek() != -1) {
         int currentHeight = heights[stack.pop()];
         int currentWidth = heights.length - stack.peek() - 1;
         maxArea = Math.max(maxArea, currentHeight * currentWidth);
      }
      return maxArea;
   }
}
