package com.coding.tasks.leetcode.google.arrays_and_strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms {

   public static void main(String[] args) {
//      System.out.println(minMeetingRooms(new int[][]{
//         {9, 16},
//         {6, 16},
//         {1, 9},
//         {3, 15}
//      }));
      System.out.println(minMeetingRooms(new int[][]{
         {7, 10},
         {2, 4}
      }));
   }

   private static int minMeetingRooms(int[][] intervals) {
      int amountOfRooms = 0;
      Arrays.sort(intervals, Comparator.comparingInt(n -> n[0]));
      PriorityQueue<Integer> endsQueue = new PriorityQueue<>(Comparator.comparingInt(n -> n));
      for (int[] interval : intervals) {
         while (!endsQueue.isEmpty() && interval[0] >= endsQueue.peek()) {
            endsQueue.poll();
         }
         endsQueue.add(interval[1]);
         amountOfRooms = Math.max(amountOfRooms, endsQueue.size());
      }

      return amountOfRooms;
   }
}
