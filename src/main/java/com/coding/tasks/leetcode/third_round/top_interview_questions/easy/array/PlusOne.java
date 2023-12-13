package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.array;

import java.util.Arrays;

public class PlusOne {

   public static void main(String[] args) {
      System.out.println(Arrays.toString(plusOne(new int[]{4, 3, 2, 1})));
      System.out.println(Arrays.toString(plusOne(new int[]{9})));
   }

   public static int[] plusOne(int[] digits) {
      int i = digits.length - 1;
      while (i >= 0) {
         if (digits[i] + 1 > 9) {
            digits[i] = 0;
            i--;
         } else {
            digits[i] = digits[i] + 1;
            break;
         }
      }
      if (i == -1) {
         int[] ans = new int[digits.length + 1];
         ans[0] = 1;
         System.arraycopy(digits, 0, ans, 1, digits.length);
         return ans;
      } else {
         return digits;
      }
   }
}
