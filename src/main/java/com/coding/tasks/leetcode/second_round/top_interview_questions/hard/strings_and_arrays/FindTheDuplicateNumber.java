package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.strings_and_arrays;

public class FindTheDuplicateNumber {

   public static void main(String[] args) {
      System.out.println(findDuplicate(new int[]{1, 3, 4, 2, 2}));
      System.out.println(findDuplicate(new int[]{3, 1, 3, 4, 2}));
   }

   private static int findDuplicate(int[] nums) {
      // Find the intersection point of the two runners.
      int slow = nums[0];
      int fast = nums[0];

      do {
         slow = nums[slow];
         fast = nums[nums[fast]];
      } while (slow != fast);

      // Find the "entrance" to the cycle.
      slow = nums[0];

      while (slow != fast) {
         slow = nums[slow];
         fast = nums[fast];
      }

      return slow;
   }
}
