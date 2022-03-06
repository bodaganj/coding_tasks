package com.coding.tasks.leetcode.top.interview.questions.medium.sorting_and_searching;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInArray {

   public static void main(String[] args) {
      System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
      System.out.println(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
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
