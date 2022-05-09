package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.design;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream {

   public static void main(String[] args) {
//      MedianFinder obj1 = new MedianFinder();
//      obj1.addNum(6);
//      System.out.println(obj1.findMedian()); // 6
//      obj1.addNum(10);
//      System.out.println(obj1.findMedian()); // 8
//      obj1.addNum(2);
//      System.out.println(obj1.findMedian()); // 6
//      obj1.addNum(6);
//      System.out.println(obj1.findMedian()); // 6
//      obj1.addNum(5);
//      System.out.println(obj1.findMedian()); // 6
//
//      MedianFinder obj2 = new MedianFinder();
//      obj2.addNum(0);
//      obj2.addNum(0);
//      System.out.println(obj2.findMedian());
//
//      MedianFinder obj3 = new MedianFinder();
//      obj3.addNum(-1);
//      System.out.println(obj3.findMedian());
//      obj3.addNum(-2);
//      System.out.println(obj3.findMedian());

      MedianFinder obj4 = new MedianFinder();
      obj4.addNum(-1);
      System.out.println(obj4.findMedian());
      obj4.addNum(-2);
      System.out.println(obj4.findMedian());
      obj4.addNum(-3);
      System.out.println(obj4.findMedian());
      obj4.addNum(-4);
      System.out.println(obj4.findMedian());
      obj4.addNum(-5);
      System.out.println(obj4.findMedian());
   }

   /**
    * Your MedianFinder object will be instantiated and called as such:
    * MedianFinder obj = new MedianFinder();
    * obj.addNum(num);
    * double param_2 = obj.findMedian();
    */
   static class MedianFinder {

      private Queue<Integer> biggestPartPq = new PriorityQueue<>();
      private Queue<Integer> smallestPartPq = new PriorityQueue<>(Collections.reverseOrder());

      public MedianFinder() {

      }

      public void addNum(int num) {
         if (biggestPartPq.isEmpty() && smallestPartPq.isEmpty()) {
            smallestPartPq.offer(num);
         } else if (biggestPartPq.size() == smallestPartPq.size()) {
            if (num > biggestPartPq.peek()) {
               smallestPartPq.offer(biggestPartPq.poll());
               biggestPartPq.offer(num);
            } else {
               smallestPartPq.offer(num);
            }
         } else {
            if (num > smallestPartPq.peek()) {
               biggestPartPq.offer(num);
            } else {
               biggestPartPq.offer(smallestPartPq.poll());
               smallestPartPq.offer(num);
            }
         }
      }

      public double findMedian() {
         if (biggestPartPq.size() == smallestPartPq.size()) {
            int lowestBig = biggestPartPq.peek();
            int highestSmall = smallestPartPq.peek();
            return (double) (lowestBig + highestSmall) / 2;
         } else {
            return (double) smallestPartPq.peek();
         }
      }
   }
}
