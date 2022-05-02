package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.sorting_and_searching;

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

      Queue<Integer> queue = new PriorityQueue<>();
      for (int[] interval : intervals) {
         if (!queue.isEmpty()) {
            if (queue.peek() <= interval[0]) {
               queue.poll();
            }
         }
         queue.offer(interval[1]);
      }
      return queue.size();
   }
}
