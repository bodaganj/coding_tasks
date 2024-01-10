package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.sorting.and.searching;

import java.util.Arrays;

public class WiggleSortII {

   public static void main(String[] args) {
      int[] num1 = new int[]{1, 5, 1, 1, 6, 4};
      wiggleSort(num1);
      System.out.println(Arrays.toString(num1));
      System.out.println("===========================");
//      int[] num2 = new int[]{1, 2, 3, 4, 5, 6};
//      wiggleSort(num2);
//      System.out.println(Arrays.toString(num2));
//      System.out.println("===========================");
//      int[] num3 = new int[]{6, 5, 4, 3, 2, 1};
//      wiggleSort(num3);
//      System.out.println(Arrays.toString(num3));
//      System.out.println("===========================");
//      int[] num4 = new int[]{2, 2, 2, 2, 3, 3, 3};
//      wiggleSort(num4);
//      System.out.println(Arrays.toString(num4));
//      System.out.println("===========================");
      int[] num7 = new int[]{2, 2, 2, 3, 3, 3, 3};
      wiggleSort(num7);
      System.out.println(Arrays.toString(num7));
      System.out.println("===========================");
//      int[] num5 = new int[]{1, 5, 1, 1, 6, 4};
//      wiggleSort(num5);
//      System.out.println(Arrays.toString(num5));
//      System.out.println("===========================");
//      int[] num6 = new int[]{1, 3, 2, 2, 3, 1};
//      wiggleSort(num6);
//      System.out.println(Arrays.toString(num6));
//      System.out.println("===========================");
   }

   public static void wiggleSort(int[] nums) {
      boolean shouldBeSmaller = true;

      int i = 0;
      while (i < nums.length - 1) {
         int curr = nums[i];
         int next = nums[i + 1];
         if (shouldBeSmaller) { // curr should be smaller than next
            if (curr > next) {
               swap(i, i + 1, nums);
               shouldBeSmaller = false;
               i++;
            } else if (curr == next) {
               int j = i + 2;
               while (j < nums.length && nums[j] == curr) {
                  j++;
               }
               if (nums[j] > next) {
                  swap(i + 1, j, nums);
                  i += 2;
               } else {
                  swap(i, j, nums);
                  i++;
               }
            } else {
               i++;
               shouldBeSmaller = false;
            }
         } else { // curr should be bigger than next
            if (curr < next) {
               swap(i, i + 1, nums);
               shouldBeSmaller = true;
               i++;
            } else if (curr == next) {
               int j = i + 2;
               while (j < nums.length && nums[j] != curr) {
                  j++;
               }
               if (nums[j] < next) {
                  swap(i + 1, j, nums);
                  i += 2;
               } else {
                  swap(i, j, nums);
                  i++;
               }
            } else {
               i++;
               shouldBeSmaller = true;
            }
         }
      }
   }

   private static void swap(int left, int right, int[] nums) {
      int tmp = nums[left];
      nums[left] = nums[right];
      nums[right] = tmp;
   }
}
