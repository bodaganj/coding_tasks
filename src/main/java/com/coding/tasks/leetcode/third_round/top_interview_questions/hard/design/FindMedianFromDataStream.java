package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.design;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream {

   public static void main(String[] args) {

   }

   class MedianFinder {

      private Queue<Integer> biggerPart;
      private Queue<Integer> smallerPart;

      public MedianFinder() {
         biggerPart = new PriorityQueue<>();
         smallerPart = new PriorityQueue<>(Comparator.reverseOrder());
      }

      public void addNum(int num) {
         if (smallerPart.size() == biggerPart.size()) {
            if (biggerPart.isEmpty()) {
               biggerPart.add(num);
            } else if (smallerPart.peek() <= num) {
               biggerPart.add(num);
            } else {
               biggerPart.add(smallerPart.poll());
               smallerPart.add(num);
            }
         } else {
            if (biggerPart.peek() < num) {
               smallerPart.add(biggerPart.poll());
               biggerPart.add(num);
            } else {
               smallerPart.add(num);
            }
         }
      }

      public double findMedian() {
         if ((biggerPart.size() + smallerPart.size()) % 2 == 0) {
            return (double) (smallerPart.peek() + biggerPart.peek()) / 2;
         } else {
            return biggerPart.peek();
         }
      }
   }
}
