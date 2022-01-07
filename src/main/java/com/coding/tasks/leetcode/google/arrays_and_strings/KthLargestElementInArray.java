package com.coding.tasks.leetcode.google.arrays_and_strings;

import java.util.Arrays;

public class KthLargestElementInArray {

   public static void main(String[] args) {
      System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
      System.out.println(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
   }

   // O(N log N)
   private static int findKthLargest(int[] nums, int k) {
      Arrays.sort(nums);
      return nums[nums.length - k];
   }

   // a bit faster O(N log k)
//   public int findKthLargest(int[] nums, int k) {
//      // init heap 'the smallest element first'
//      PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(n -> n));
//
//      // keep k largest elements in the heap
//      for (int n: nums) {
//         heap.add(n);
//         if (heap.size() > k)
//            heap.poll();
//      }
//
//      // output
//      return heap.poll();
//   }
}
