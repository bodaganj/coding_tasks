package com.coding.tasks.leetcode.amazon.sorting_and_searching;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRooms2 {

   public static void main(String[] args) {
      System.out.println(minMeetingRooms(new int[][]{
         {0, 30},
         {5, 10},
         {15, 20}
      }));

      System.out.println(minMeetingRooms(new int[][]{
         {7, 10},
         {2, 4}
      }));
   }

   private static int minMeetingRooms(int[][] intervals) {
      Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

      int minMeetingRooms = 1;
      Queue<Integer> queue = new PriorityQueue<>();
      queue.offer(intervals[0][1]);

      for (int i = 1; i < intervals.length; i++) {
         while (!queue.isEmpty() && queue.peek() <= intervals[i][0]) {
            queue.poll();
         }
         queue.add(intervals[i][1]);

         minMeetingRooms = Math.max(minMeetingRooms, queue.size());
      }

      return minMeetingRooms;
   }
}
