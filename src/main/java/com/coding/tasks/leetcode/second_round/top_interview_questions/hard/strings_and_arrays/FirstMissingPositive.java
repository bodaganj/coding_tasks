package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.strings_and_arrays;

public class FirstMissingPositive {

   public static void main(String[] args) {
      System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
      System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
      System.out.println(firstMissingPositive(new int[]{1}));
      System.out.println(firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
      System.out.println(firstMissingPositive(new int[]{1, 1}));
   }

   private static int firstMissingPositive(int[] nums) {
      int n = nums.length;
      // check if 1 is present
      int contains = 0;
      for (int num : nums) {
         if (num == 1) {
            contains++;
            break;
         }
      }
      if (contains == 0) {
         return 1;
      }

      // mark all nums[i] <= 0 or > n as 1
      for (int i = 0; i < n; i++) {
         if ((nums[i] <= 0) || (nums[i] > n)) {
            nums[i] = 1;
         }
      }

      // mark all present indexes
      for (int i = 0; i < n; i++) {
         int a = Math.abs(nums[i]);
         if (a == n) {
            nums[0] = -Math.abs(nums[0]);
         } else {
            nums[a] = -Math.abs(nums[a]);
         }
      }

      // get first missing positive integer
      for (int i = 1; i < n; i++) {
         if (nums[i] > 0) {
            return i;
         }
      }
      if (nums[0] > 0) {
         return n;
      }
      return n + 1;
   }
}
