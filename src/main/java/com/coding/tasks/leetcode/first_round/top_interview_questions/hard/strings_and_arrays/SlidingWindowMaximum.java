package com.coding.tasks.leetcode.first_round.top_interview_questions.hard.strings_and_arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

   public static void main(String[] args) {
      System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
      System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, -1}, 1)));
   }

   // Time Limit Exceeded
   private static int[] maxSlidingWindow(int[] nums, int k) {
      if (k > nums.length) {
         return new int[]{};
      }

      PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
      int[] res = new int[nums.length - k + 1];
      int left = 0;
      for (int i = 0; i < nums.length; i++) {
         if (queue.size() < k) {
            queue.add(nums[i]);
         } else {
            res[left] = queue.peek();
            queue.remove(nums[left]);
            queue.add(nums[i]);
            left++;
         }
         if (i == nums.length - 1) {
            res[left] = queue.peek();
         }
      }

      return res;
   }
}
