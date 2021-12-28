package com.coding.tasks.leetcode.top.interview.questions.easy.array;

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
      int length = nums.length;
      if (nums.length <= 1) {
         return;
      }
      int[] newArray = new int[length];

      for (int i = 0; i < length; i++) {
         newArray[(i + k) % length] = nums[i];
      }

      System.arraycopy(newArray, 0, nums, 0, nums.length);
   }

   /*
     best one!!!
    */
//   public void rotate(int[] nums, int k) {
//      k %= nums.length;
//      reverse(nums, 0, nums.length - 1);
//      reverse(nums, 0, k - 1);
//      reverse(nums, k, nums.length - 1);
//   }
//   public void reverse(int[] nums, int start, int end) {
//      while (start < end) {
//         int temp = nums[start];
//         nums[start] = nums[end];
//         nums[end] = temp;
//         start++;
//         end--;
//      }
//   }
}
