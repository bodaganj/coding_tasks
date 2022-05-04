package com.coding.tasks.leetcode.second_round.amazon.sorting_and_searching;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInArray {

   public static void main(String[] args) {

   }

   private static int findKthLargest(int[] nums, int k) {
      Queue<Integer> pq = new PriorityQueue<>();
      for (int num : nums) {
         pq.offer(num);
         while (pq.size() > k) {
            pq.poll();
         }
      }
      return pq.poll();
   }
}
