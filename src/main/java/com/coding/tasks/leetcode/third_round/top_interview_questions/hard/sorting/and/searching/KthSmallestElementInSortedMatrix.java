package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.sorting.and.searching;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElementInSortedMatrix {

   public static void main(String[] args) {

   }

   public int kthSmallest(int[][] matrix, int k) {
      Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
      for (int[] ints : matrix) {
         for (int anInt : ints) {
            queue.add(anInt);
            if (queue.size() > k) {
               queue.poll();
            }
         }
      }
      return queue.poll();
   }
}
