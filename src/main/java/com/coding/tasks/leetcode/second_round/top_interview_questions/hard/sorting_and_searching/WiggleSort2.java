package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.sorting_and_searching;

import java.util.Arrays;

public class WiggleSort2 {

   public static void main(String[] args) {
      int[] arr1 = new int[]{1, 5, 1, 1, 6, 4};
      int[] arr2 = new int[]{1, 3, 2, 2, 3, 1};
      int[] arr3 = new int[]{1, 4, 3, 4, 1, 2, 1, 3, 1, 3, 2, 3, 3};

      wiggleSort(arr1);
      wiggleSort(arr2);
      wiggleSort(arr3);

//      System.out.println(Arrays.toString(arr1));
//      System.out.println(Arrays.toString(arr2));
      System.out.println(Arrays.toString(arr3));
   }

   private static void wiggleSort(int[] nums) {
      int slow = 0;
      int fast = 1;
      boolean flag = true;

      while (fast < nums.length) {
         if (flag) {
            if (nums[fast] <= nums[slow]) {
               if (nums[fast] < nums[slow]) {
                  swap(nums, fast, slow);
               } else {
                  int counter = fast;
                  while (nums[fast] == nums[slow] && counter < nums.length) {
                     if (nums[counter] > nums[slow]) {
                        swap(nums, fast, counter);
                     } else if (nums[counter] < nums[slow]) {
                        swap(nums, counter, slow);
                     }
                     counter++;
                  }
               }
            }
            fast++;
            slow++;
            flag = false;
         } else {
            if (nums[fast] >= nums[slow]) {
               if (nums[fast] > nums[slow]) {
                  swap(nums, fast, slow);
               } else {
                  int counter = fast;
                  while (nums[fast] == nums[slow] && counter < nums.length) {
                     if (nums[counter] > nums[slow]) {
                        swap(nums, slow, counter);
                     } else if (nums[counter] < nums[slow]) {
                        swap(nums, counter, fast);
                     }
                     counter++;
                  }
               }
            }

            slow++;
            fast++;
            flag = true;
         }
      }
   }

   private static void wiggleSort1(int[] nums) {
      boolean flag = true;
      for (int i = 0; i < nums.length - 1; i++) {
         if (flag) {
            if (nums[i] >= nums[i + 1]) {
               swap(nums, i, i + 1);
            }
            flag = false;
         } else {
            if (nums[i] <= nums[i + 1]) {
               swap(nums, i, i + 1);
            }
            flag = true;
         }
      }
   }

   private static void swap(int[] nums, int left, int right) {
      int tmp = nums[left];
      nums[left] = nums[right];
      nums[right] = tmp;
   }
}
