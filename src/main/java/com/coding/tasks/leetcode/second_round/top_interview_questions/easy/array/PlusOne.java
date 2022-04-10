package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.array;

public class PlusOne {

   public int[] plusOne(int[] digits) {
      for (int i = digits.length - 1; i >= 0; i--) {
         if (digits[i] != 9) {
            digits[i] = digits[i] + 1;
            return digits;
         } else {
            digits[i] = 0;
         }
      }

      int[] ans = new int[digits.length + 1];
      ans[0] = 1;
      return ans;
   }
}
