package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.sorting_and_searching;

public class MedianOfTwoSortedArrays {

   public static void main(String[] args) {
      System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
      System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
      System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 7}));
      System.out.println(findMedianSortedArrays(new int[]{3}, new int[]{1, 2, 5, 6, 7}));
   }

   private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int length1 = nums1.length;
      int length2 = nums2.length;
      if (length1 < length2) {
         return findMedianSortedArrays(nums2, nums1);   // Make sure length1 is the shorter one.
      }

      int left = 0, right = length2 * 2;
      while (left <= right) {
         int mid2 = (left + right) / 2;   // Try Cut 2
         int mid1 = length1 + length2 - mid2;  // Calculate Cut 1 accordingly

         double L1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1) / 2];   // Get L1, R1, L2, R2 respectively
         double L2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2 - 1) / 2];
         double R1 = (mid1 == length1 * 2) ? Integer.MAX_VALUE : nums1[(mid1) / 2];
         double R2 = (mid2 == length2 * 2) ? Integer.MAX_VALUE : nums2[(mid2) / 2];

         if (L1 > R2) {
            left = mid2 + 1;      // A1's lower half is too big; need to move C1 left (C2 right)
         } else if (L2 > R1) {
            right = mid2 - 1;   // A2's lower half too big; need to move C2 left.
         } else {
            return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;   // Otherwise, that's the right cut.
         }
      }
      return -1;
   }
}
