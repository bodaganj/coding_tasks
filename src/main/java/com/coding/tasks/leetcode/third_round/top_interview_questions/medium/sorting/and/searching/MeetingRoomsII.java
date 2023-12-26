package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.sorting.and.searching;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoomsII {

   public static void main(String[] args) {

   }

   public static int minMeetingRooms(int[][] intervals) {
      Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
      int max = 0;
      Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
      for (int[] interval : intervals) {
         if (queue.isEmpty()) {
            queue.add(interval);
         } else {
            while (queue.size() != 0 && queue.peek()[1] <= interval[0]) {
               queue.poll();
            }
            queue.add(interval);
         }
         max = Math.max(max, queue.size());
      }
      return max;
   }
}
