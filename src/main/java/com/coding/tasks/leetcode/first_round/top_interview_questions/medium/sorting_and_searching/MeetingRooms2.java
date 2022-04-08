package com.coding.tasks.leetcode.first_round.top_interview_questions.medium.sorting_and_searching;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRooms2 {

   public static void main(String[] args) {
      System.out.println(minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
      System.out.println(minMeetingRooms(new int[][]{{2, 4}, {7, 10}}));
   }

   private static int minMeetingRooms(int[][] intervals) {
      Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

      int maxRooms = 1;
      Queue<Integer> queue = new PriorityQueue<>();
      queue.offer(intervals[0][1]);

      for (int i = 1; i < intervals.length; i++) {
         if (queue.peek() <= intervals[i][0]) {
            queue.poll();
         }
         queue.offer(intervals[i][1]);

         maxRooms = Math.max(maxRooms, queue.size());
      }

      return maxRooms;
   }
}
