package com.coding.tasks.leetcode.third_round.google.sorting.and.searching;

public class PeakIndexInMountainArray {

  public static void main(String[] args) {
    System.out.println(peakIndexInMountainArray(new int[]{0, 1, 0}));
    System.out.println(peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
    System.out.println(peakIndexInMountainArray(new int[]{0, 10, 5, 2}));
  }

  public static int peakIndexInMountainArray(int[] arr) {
    int left = 1;
    int right = arr.length - 2;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
        return mid;
      } else if (arr[mid] < arr[mid - 1]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }
}
