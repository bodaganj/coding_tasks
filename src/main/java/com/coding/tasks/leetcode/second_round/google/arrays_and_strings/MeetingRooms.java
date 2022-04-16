package com.coding.tasks.leetcode.second_round.google.arrays_and_strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRooms {

   public static void main(String[] args) {
      System.out.println(minMeetingRooms(new int[][]{
         {9, 16},
         {6, 16},
         {1, 9},
         {3, 15}
      }));
      System.out.println(minMeetingRooms(new int[][]{
         {7, 10},
         {2, 4}
      }));
      System.out.println(minMeetingRooms(new int[][]{
         {6, 15},
         {13, 20},
         {6, 17}
      }));
   }

   private static int minMeetingRooms(int[][] intervals) {
      Arrays.sort(intervals, Comparator.comparingInt(in -> in[0])); // N logN

      int min = 0;
      Queue<Integer> pq = new PriorityQueue<>();
      for (int[] interval : intervals) { // N
         while (!pq.isEmpty() && pq.peek() <= interval[0]) {
            pq.poll(); // log K
         }
         pq.offer(interval[1]);

         min = Math.max(min, pq.size());
      }
      return min;
   }
}
