package com.coding.tasks.leetcode.top.interview.questions.medium.array_and_strings;

public class IncreasingTripletSubsequence {

   public static void main(String[] args) {
      System.out.println(increasingTriplet(new int[]{1, 2, 3, 4, 5})); // true
      System.out.println(increasingTriplet(new int[]{5, 4, 3, 2, 1})); // false
      System.out.println(increasingTriplet(new int[]{2, 1, 5, 0, 4, 6})); // true
      System.out.println(increasingTriplet(new int[]{2, 4, -2, -3})); // false
      System.out.println(increasingTriplet(new int[]{1, 5, 0, 4, 1, 3})); // true
   }

   private static boolean increasingTriplet(int[] nums) {
      if (nums.length < 3) {
         return false;
      }

      int first = Integer.MAX_VALUE;
      int second = Integer.MAX_VALUE;

      for (int num : nums) {
         if (num <= first) {
            first = num;
         } else if (num <= second) {
            second = num;
         } else {
            return true;
         }
      }
      return false;
   }
}
