package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.others;

public class MissingNumber {

   public int missingNumber(int[] nums) {
      int expSum = 0;
      for (int i = 1; i <= nums.length; i++) {
         expSum += i;
      }
      int actSum = 0;
      boolean zeroAbsence = true;
      for (int num : nums) {
         if (num == 0) {
            zeroAbsence = false;
         }
         actSum += num;
      }

      if (zeroAbsence) {
         return 0;
      }

      return expSum - actSum;
   }
}
