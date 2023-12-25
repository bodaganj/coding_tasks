package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.sorting.and.searching;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArray {

   public int findKthLargest(int[] nums, int k) {
      Queue<Integer> queue = new PriorityQueue<>();
      for (int num : nums) {
         queue.add(num);
         if (queue.size() > k) {
            queue.poll();
         }
      }
      return queue.poll();
   }
}
