package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.dynamic.programming;

public class LongestIncreasingSubsequence {

   public static void main(String[] args) {
      System.out.println(lengthOfLIS(new int[]{50, 60, 1, 2, 3})); // 3
      System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18})); // 4
      System.out.println(lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3})); // 4
      System.out.println(lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7})); // 1
      System.out.println(lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6})); // 6
   }

   public static int lengthOfLIS(int[] nums) {
      if (nums.length == 1) {
         return 1;
      }
      int ans = 0;
      int index = 1;
      int prevPrev = nums[0];
      int prev = Integer.MAX_VALUE;
      for (int i = 1; i < nums.length; i++) {
         if (nums[i] == prev || nums[i] == prevPrev) {
            continue;
         }
         if (nums[i] < prevPrev) {
            prevPrev = nums[i];
            ans = Math.max(ans, index);
            index = 1;
         } else if (nums[i] < prev) {
            prev = nums[i];
            if (index == 1) {
               index++;
            }
         } else {
            prevPrev = prev;
            prev = nums[i];
            index++;
         }
      }
      ans = Math.max(ans, index);

      return ans;
   }
}
