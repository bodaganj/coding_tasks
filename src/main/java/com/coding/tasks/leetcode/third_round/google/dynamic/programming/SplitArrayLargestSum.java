package com.coding.tasks.leetcode.third_round.google.dynamic.programming;

import com.coding.tasks.cracking.the.code.recursion_and_dp.MaximumHeightByStackingCuboids;

public class SplitArrayLargestSum {

  private static int max = Integer.MAX_VALUE;
  private static int length = Integer.MAX_VALUE;

  public static void main(String[] args) {
    System.out.println(splitArray(new int[]{7, 2, 5, 10, 8}, 2));
    System.out.println(splitArray(new int[]{1, 2, 3, 4, 5}, 2));
  }

  public static int splitArray(int[] nums, int k) {
    max = Integer.MAX_VALUE;
    int maxNumber = 0;
    for (int num : nums) {
      maxNumber = Math.max(maxNumber, num);
    }

    length = nums.length;
    int[] sum = getSum(nums);
    split(0, 0, sum, k, maxNumber);
    return max;
  }


  private static void split(int currentIndex, int currentMax, int[] sum, int leftArrays, int maxNumber) {
    if (leftArrays == 1) {
      if (sum[length] - sum[currentIndex] > max) {
        return;
      } else {
        currentMax = Math.max(currentMax, sum[length] - sum[currentIndex]);
        split(length, currentMax, sum, 0, maxNumber);
      }
    }
    if (leftArrays == 0 && currentIndex != length) {
      return;
    }
    if (currentMax > max) {
      return;
    }
    if (leftArrays == 0) {
      max = currentMax;
    } else {
      int i = currentIndex;
      while (i < length - (leftArrays - 1)) {
        if (sum[i + 1] - sum[currentIndex] > max) {
          break;
        } else {
          while (i + 2 <= length && sum[i + 2] - sum[currentIndex] < maxNumber) {
            i++;
          }
          currentMax = Math.max(currentMax, sum[i + 1] - sum[currentIndex]);
          split(i + 1, currentMax, sum, leftArrays - 1, maxNumber);
        }
        i++;
      }
    }
  }

  private static int[] getSum(int[] nums) {
    int[] sum = new int[nums.length + 1];
    for (int i = 1; i < sum.length; i++) {
      sum[i] = sum[i - 1] + nums[i - 1];
    }
    return sum;
  }
}
