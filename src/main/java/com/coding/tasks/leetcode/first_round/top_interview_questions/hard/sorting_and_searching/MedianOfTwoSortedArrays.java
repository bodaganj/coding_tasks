package com.coding.tasks.leetcode.first_round.top_interview_questions.hard.sorting_and_searching;

public class MedianOfTwoSortedArrays {

   public static void main(String[] args) {
      System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
   }

   private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int fLength = nums1.length;
      int sLength = nums2.length;

      double fMed;
      if (fLength == 1) {
         fMed = nums1[0];
      } else if (fLength % 2 == 0) {
         fMed = (double) (nums1[fLength / 2 - 1] + nums1[fLength / 2]) / 2;
      } else {
         fMed = nums1[fLength / 2];
      }

      double sMed;
      if (sLength == 1) {
         sMed = nums2[0];
      } else if (sLength % 2 == 0) {
         sMed = (double) (nums2[sLength / 2 - 1] + nums2[sLength / 2]) / 2;
      } else {
         sMed = nums2[sLength / 2];
      }

      return (fMed + sMed) / 2;
   }
}
