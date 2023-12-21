package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.array.and.string;

public class IncreasingTripletSubsequence {

   public boolean increasingTriplet(int[] nums) {
      int n1 = Integer.MAX_VALUE;
      int n2 = Integer.MAX_VALUE;
      for (int num : nums) {
         if (n1 >= num) {
            n1 = num;
         } else if (n2 >= num) {
            n2 = num;
         } else {
            return true;
         }
      }
      return false;
   }
}
