package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.sorting_and_searching;

public class MedianOfTwoSortedArrays {

   public static void main(String[] args) {
      System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
      System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
      System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 7}));
      System.out.println(findMedianSortedArrays(new int[]{3}, new int[]{1, 2, 5, 6, 7}));
   }

   // Watch Tushar video!
   private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
      //if input1 length is greater than switch them so that input1 is smaller than input2.
      if (nums1.length > nums2.length) {
         return findMedianSortedArrays(nums2, nums1);
      }
      int shortLength = nums1.length;
      int longLength = nums2.length;

      int low = 0;
      int high = shortLength;
      while (low <= high) {

         // where to cut short array (so all left elements are smaller, then right (with elements from second array))
         // where to cut long array (so all left elements are smaller, then right (with elements from fisrt array))
         // but the sum of all left is equal to the sem of all right elements (or one more on the left side)
         int partitionX = (low + high) / 2;
         int partitionY = (shortLength + longLength + 1) / 2 - partitionX;

         //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
         //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
         int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
         int minRightX = partitionX == shortLength ? Integer.MAX_VALUE : nums1[partitionX];

         int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1];
         int minRightY = partitionY == longLength ? Integer.MAX_VALUE : nums2[partitionY];

         if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
            //We have partitioned array at correct place
            // Now get max of left elements and min of right elements to get the median in case of even length combined array size
            // or get max of left for odd length combined array size.
            if ((shortLength + longLength) % 2 == 0) {
               return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
            } else {
               return Math.max(maxLeftX, maxLeftY);
            }
         } else if (maxLeftX > minRightY) { //we are too far on right side for partitionX. Go on left side.
            high = partitionX - 1;
         } else { //we are too far on left side for partitionX. Go on right side.
            low = partitionX + 1;
         }
      }

      //Only we we can come here is if input arrays were not sorted. Throw in that scenario.
      return -1;
   }
}
