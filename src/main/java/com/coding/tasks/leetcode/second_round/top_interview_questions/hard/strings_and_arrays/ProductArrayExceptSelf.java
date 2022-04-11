package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.strings_and_arrays;

import java.util.Arrays;

public class ProductArrayExceptSelf {

   public static void main(String[] args) {
      System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
   }

   private static int[] productExceptSelf(int[] nums) {
      int[] ans = new int[nums.length];
      ans[0] = 1;

      int counter = 1;
      int product = 1;
      while (counter < ans.length) {
         product *= nums[counter - 1];
         ans[counter] = product;
         counter++;
      }

      product = 1;
      counter = ans.length - 1;
      while (counter >= 0) {
         ans[counter] = ans[counter] * product;
         product *= nums[counter];
         counter--;
      }

      return ans;
   }
}
