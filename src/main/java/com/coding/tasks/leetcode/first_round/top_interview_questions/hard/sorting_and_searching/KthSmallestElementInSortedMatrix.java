package com.coding.tasks.leetcode.first_round.top_interview_questions.hard.sorting_and_searching;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElementInSortedMatrix {

   public static void main(String[] args) {
      int[][] arr = new int[][]{
         {1, 5, 9},
         {10, 11, 13},
         {12, 13, 15}
      };
      System.out.println(kthSmallest(arr, 8));
   }

   private static int kthSmallest(int[][] matrix, int k) {
      int amount = matrix.length * matrix.length;
      Queue<Integer> queue;

      if (amount / 2 > k) {
         // amount - k + 1 greatest
         int expectedSize = amount - k + 1;
         queue = new PriorityQueue<>();
         for (int[] ints : matrix) {
            for (int anInt : ints) {
               queue.offer(anInt);
               if (queue.size() > expectedSize) {
                  queue.poll();
               }
            }
         }
      } else {
         // k smallest
         queue = new PriorityQueue<>(Collections.reverseOrder());
         for (int[] ints : matrix) {
            for (int anInt : ints) {
               queue.offer(anInt);
               if (queue.size() > k) {
                  queue.poll();
               }
            }
         }
      }

      return queue.poll();
   }
}
