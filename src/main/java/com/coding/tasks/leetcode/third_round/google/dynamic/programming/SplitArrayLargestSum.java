package com.coding.tasks.leetcode.third_round.google.dynamic.programming;

public class SplitArrayLargestSum {

  private static int max = Integer.MAX_VALUE;
  private static int length = Integer.MAX_VALUE;

  public static void main(String[] args) {
    System.out.println(splitArray(new int[]{7, 2, 5, 10, 8}, 2));
    System.out.println(splitArray(new int[]{1, 2, 3, 4, 5}, 2));
  }

  public static int splitArray(int[] nums, int k) {
    max = Integer.MAX_VALUE;
    length = nums.length;
    int[] sum = getSum(nums);
    split(0, 0, sum, k);
    return max;
  }

  private static int[] getSum(int[] nums) {
    int[] sum = new int[nums.length + 1];
    for (int i = 1; i < sum.length; i++) {
      sum[i] = sum[i - 1] + nums[i - 1];
    }
    return sum;
  }

  private static void split(int currentIndex, int currentMax, int[] sum, int leftArrays) {
    if (leftArrays == 0 && currentIndex != length) {
      return;
    }
    if (currentMax > max) {
      return;
    }
    if (leftArrays == 0) {
      max = currentMax;
    } else {
      for (int i = currentIndex; i < length - (leftArrays - 1); i++) {
        if (sum[i + 1] - sum[currentIndex] > max) {
          break;
        } else {
          currentMax = Math.max(currentMax, sum[i + 1] - sum[currentIndex]);
          split(i + 1, currentMax, sum, leftArrays - 1);
        }
      }
    }
  }
}
