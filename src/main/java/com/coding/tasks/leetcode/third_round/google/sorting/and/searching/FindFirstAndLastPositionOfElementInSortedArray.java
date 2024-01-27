package com.coding.tasks.leetcode.third_round.google.sorting.and.searching;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(searchRange(new int[]{1, 2, 3, 3, 3, 3, 4, 5, 9}, 3))); // 2,5
    System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8))); // 3,4
    System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 7))); // 1,2
    System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 5))); // 0,0
    System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 10))); // 5,5
    System.out.println(Arrays.toString(searchRange(new int[]{2, 2}, 2))); // 0, 1
  }

  public static int[] searchRange(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return new int[]{findStart(left, mid, target, nums), findEnd(mid, right, target, nums)};
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return new int[]{-1, -1};
  }

  private static int findStart(int left, int right, int target, int[] nums) {
    while (right != 0 && nums[right - 1] == target) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid;
      } else {
        right = mid;
      }
    }
    return right;
  }

  private static int findEnd(int left, int right, int target, int[] nums) {
    while (left != nums.length - 1 && nums[left + 1] == target) {
      int mid = left + (right - left) / 2;
      if (nums[mid] > target) {
        right = mid;
      } else {
        left = mid;
      }
    }
    return left;
  }
}
