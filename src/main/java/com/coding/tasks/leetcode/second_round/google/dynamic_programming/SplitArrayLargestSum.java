package com.coding.tasks.leetcode.second_round.google.dynamic_programming;

import java.util.Arrays;

public class SplitArrayLargestSum {

   private static int min = Integer.MAX_VALUE;

   public static void main(String[] args) {
      System.out.println(splitArray(new int[]{7, 2, 6, 3, 4, 8, 1}, 3));
   }

   private static int splitArray(int[] nums, int m) {
      if (m == 1) {
         return Arrays.stream(nums).sum();
      }
      min = Integer.MAX_VALUE;
      backtrack(nums, 0, m, Integer.MIN_VALUE);
      return min;
   }

   private static int backtrack(int[] nums, int start, int m, int max) {
      int sum = 0;
      if (m == 1) {
         for (int j = start; j < nums.length; j++) {
            sum += nums[j];
         }
         return Math.max(max, sum);
      } else {
         for (int i = start; i <= nums.length - m; i++) {
            sum += nums[i];
            min = Math.min(min, backtrack(nums, i + 1, m - 1, Math.max(sum, max)));
         }
      }
      return min;
   }

//   private static int splitArray(int[] nums, int m) {
//      int n = nums.length;
//      int[][] memo = new int[n + 1][m + 1];
//
//      // Store the prefix sum of nums array
//      int[] prefixSum = new int[n + 1];
//      for (int i = 0; i < n; i++) {
//         prefixSum[i + 1] = prefixSum[i] + nums[i];
//      }
//
//      for (int subarrayCount = 1; subarrayCount <= m; subarrayCount++) {
//         for (int currIndex = 0; currIndex < n; currIndex++) {
//            // Base Case: If there is only one subarray left, then all of the remaining numbers
//            // must go in the current subarray. So return the sum of the remaining numbers.
//            if (subarrayCount == 1) {
//               memo[currIndex][subarrayCount] = prefixSum[n] - prefixSum[currIndex];
//               continue;
//            }
//
//            // Otherwise, use the recurrence relation to determine the minimum largest subarray
//            // sum between currIndex and the end of the array with subarrayCount subarray remaining.
//            int minimumLargestSplitSum = Integer.MAX_VALUE;
//            for (int i = currIndex; i <= n - subarrayCount; i++) {
//               // Store the sum of the first subarray.
//               int firstSplitSum = prefixSum[i + 1] - prefixSum[currIndex];
//
//               // Find the maximum subarray sum for the current first split.
//               int largestSplitSum = Math.max(firstSplitSum, memo[i + 1][subarrayCount - 1]);
//
//               // Find the minimum among all possible combinations.
//               minimumLargestSplitSum = Math.min(minimumLargestSplitSum, largestSplitSum);
//
//               if (firstSplitSum >= minimumLargestSplitSum) {
//                  break;
//               }
//            }
//
//            memo[currIndex][subarrayCount] = minimumLargestSplitSum;
//         }
//      }
//
//      return memo[0][m];
//   }
//
//   // Top-Down
//   private static int splitArray1(int[] nums, int m) {
//      // Store the prefix sum of nums array.
//      int n = nums.length;
//      int[] prefixSum = new int[n + 1];
//
//      for (int i = 0; i < n; i++) {
//         prefixSum[i + 1] = prefixSum[i] + nums[i];
//      }
//
//      return getMinimumLargestSplitSum(prefixSum, 0, m, new Integer[n + 1][m + 1]);
//   }
//
//   private static int getMinimumLargestSplitSum(int[] prefixSum, int currIndex, int subarrayCount, Integer[][] memo) {
//      int n = prefixSum.length - 1;
//
//      // We have already calculated the answer so no need to go into recursion
//      if (memo[currIndex][subarrayCount] != null) {
//         return memo[currIndex][subarrayCount];
//      }
//
//      // Base Case: If there is only one subarray left, then all of the remaining numbers
//      // must go in the current subarray. So return the sum of the remaining numbers.
//      if (subarrayCount == 1) {
//         return memo[currIndex][subarrayCount] = prefixSum[n] - prefixSum[currIndex];
//      }
//
//      // Otherwise, use the recurrence relation to determine the minimum largest subarray
//      // sum between currIndex and the end of the array with subarrayCount subarrays remaining.
//      int minimumLargestSplitSum = Integer.MAX_VALUE;
//      for (int i = currIndex; i <= n - subarrayCount; i++) {
//         // Store the sum of the first subarray.
//         int firstSplitSum = prefixSum[i + 1] - prefixSum[currIndex];
//
//         // Find the maximum subarray sum for the current first split.
//         int largestSplitSum = Math.max(firstSplitSum,
//                                        getMinimumLargestSplitSum(prefixSum, i + 1, subarrayCount - 1, memo));
//
//         // Find the minimum among all possible combinations.
//         minimumLargestSplitSum = Math.min(minimumLargestSplitSum, largestSplitSum);
//
//         if (firstSplitSum >= minimumLargestSplitSum) {
//            break;
//         }
//      }
//
//      return memo[currIndex][subarrayCount] = minimumLargestSplitSum;
//   }
}
