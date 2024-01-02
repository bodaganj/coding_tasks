package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.array.and.strings;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingWindowMaximum {

   public static void main(String[] args) {
      System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
      System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, -1}, 1)));
   }

   public static int[] maxSlidingWindow(int[] nums, int k) {
      int[] ans = new int[nums.length - k + 1];
      Queue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
      for (int i = 0; i < k; i++) {
         queue.add(new int[]{nums[i], i});
      }
      ans[0] = queue.peek()[0];

      for (int i = k; i < nums.length; i++) {
         queue.add(new int[]{nums[i], i});
         while (queue.peek()[1] < i - k + 1) {
            queue.poll();
         }
         ans[i - k + 1] = queue.peek()[0];
      }

      return ans;
   }
}
