package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.strings_and_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingWindowMaximum {

   public static void main(String[] args) {
      System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
      System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, -1}, 1)));
   }

   private static int[] maxSlidingWindow(int[] nums, int k) {
      List<Integer> ans = new ArrayList<>();
      Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
      for (int i = 0; i < k; i++) {
         pq.offer(new int[]{nums[i], i});
      }
      ans.add(pq.element()[0]);

      int left = 0;
      int right = k;
      while (right < nums.length) {
         pq.add(new int[]{nums[right], right});
         while (!pq.isEmpty() && pq.peek()[1] <= left) {
            pq.poll();
         }
         left++;
         right++;
         ans.add(pq.peek()[0]);
      }

      int[] res = new int[ans.size()];
      for (int i = 0; i < ans.size(); i++) {
         res[i] = ans.get(i);
      }

      return res;
   }
}
