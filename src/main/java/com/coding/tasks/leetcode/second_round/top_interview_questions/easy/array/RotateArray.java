package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.array;

import java.util.Arrays;

public class RotateArray {

   public static void main(String[] args) {
      int[] arr1 = new int[]{1, 2};
      System.out.println(Arrays.toString(arr1));
      rotate(arr1, 3);
      System.out.println(Arrays.toString(arr1));

      int[] arr2 = new int[]{1, 2, 3, 4, 5, 6, 7};
      System.out.println(Arrays.toString(arr2));
      rotate(arr2, 3);
      System.out.println(Arrays.toString(arr2));
   }

   private static void rotate(int[] nums, int k) {
   }
}
