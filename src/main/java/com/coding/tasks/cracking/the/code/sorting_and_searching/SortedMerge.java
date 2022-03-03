package com.coding.tasks.cracking.the.code.sorting_and_searching;

import java.util.Arrays;

public class SortedMerge {

   public static void main(String[] args) {
      int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
      int[] nums2 = new int[]{2, 5, 6};
      System.out.println(Arrays.toString(nums1));
      merge(nums1, 3, nums2, 3);
      System.out.println(Arrays.toString(nums1));

      int[] nums3 = new int[]{2, 0};
      int[] nums4 = new int[]{1};
      System.out.println(Arrays.toString(nums3));
      merge(nums3, 1, nums4, 1);
      System.out.println(Arrays.toString(nums3));
   }

   /**
    * Space complexity can be improved!!
    */
   private static void merge(int[] nums1, int m, int[] nums2, int n) {
      if (nums2 == null || n == 0) {
         return;
      }

      int[] tmp = new int[nums1.length];
      int i = 0;
      int first = 0;
      int second = 0;

      while (first < m && second < n) {
         if (nums1[first] < nums2[second]) {
            tmp[i] = nums1[first];
            first++;
         } else {
            tmp[i] = nums2[second];
            second++;
         }
         i++;
      }

      while (first < m) {
         tmp[i] = nums1[first];
         i++;
         first++;
      }

      while (second < n) {
         tmp[i] = nums2[second];
         i++;
         second++;
      }

      System.arraycopy(tmp, 0, nums1, 0, tmp.length);
   }
}
