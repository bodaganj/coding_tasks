package com.coding.tasks.leetcode.third_round.google.sorting.and.searching;

import com.sun.jdi.PathSearchingVirtualMachine;

public class MedianOfTwoSortedArrays {

  public static void main(String[] args) {
    System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 7}));
    System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4}));
    System.out.println(findMedianSortedArrays(new int[]{1, 3, 5}, new int[]{2, 4}));
    System.out.println(findMedianSortedArrays(new int[]{10, 15}, new int[]{20}));
    System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    System.out.println(findMedianSortedArrays(new int[]{10}, new int[]{15, 20}));
  }

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1.length <= nums2.length) {
      return get(nums1, nums2);
    } else {
      return get(nums2, nums1);
    }
  }

  private static double get(int[] small, int[] big) {
    int totalAmount = small.length + big.length;
    int left = 0;
    int right = small.length;

    while (left <= right) {
      int smallPartition = left + (right - left + 1) / 2;
      int bigPartition = (totalAmount + 1) / 2 - smallPartition;

      int smallLeft = smallPartition > 0 ? small[smallPartition - 1] : Integer.MIN_VALUE;
      int smallRight = smallPartition < small.length ? small[smallPartition] : Integer.MAX_VALUE;
      int bigLeft = bigPartition > 0 ? big[bigPartition - 1] : Integer.MIN_VALUE;
      int bigRight = bigPartition < big.length ? big[bigPartition] : Integer.MAX_VALUE;

      if (smallLeft <= bigRight && bigLeft <= smallRight) {
        return totalAmount % 2 == 0 ? (double) (Math.max(smallLeft, bigLeft) + Math.min(bigRight, smallRight)) / 2 : Math.max(smallLeft, bigLeft);
      } else if (smallLeft > bigRight) {
        right = smallPartition - 1;
      } else {
        left = smallPartition + 1;
      }
    }

    return 0.0;
  }
}
