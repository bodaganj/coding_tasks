package com.coding.tasks.leetcode.first_round.amazon.sorting_and_searching;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInArray {

   public static void main(String[] args) {

   }

   private static int findKthLargest(int[] nums, int k) {
      Queue<Integer> queue = new PriorityQueue<>();

      for (int num : nums) {
         queue.offer(num);
         if (queue.size() > k) {
            queue.poll();
         }
      }
      return queue.poll();
   }
}
