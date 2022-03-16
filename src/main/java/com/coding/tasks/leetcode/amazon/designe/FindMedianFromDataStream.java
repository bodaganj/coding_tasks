package com.coding.tasks.leetcode.amazon.designe;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream {

   public static void main(String[] args) {
      MedianFinder obj = new MedianFinder();
      obj.addNum(-1);
      System.out.println(obj.findMedian()); // -1.0
      obj.addNum(-2);
      System.out.println(obj.findMedian()); // -1.5
      obj.addNum(-3);
      System.out.println(obj.findMedian()); // -2.0
      obj.addNum(-4);
      System.out.println(obj.findMedian()); // -2.5
      obj.addNum(-5);
      System.out.println(obj.findMedian()); // -3.0
   }

   /**
    * Your MedianFinder object will be instantiated and called as such:
    * MedianFinder obj = new MedianFinder();
    * obj.addNum(num);
    * double param_2 = obj.findMedian();
    */
   static class MedianFinder {

      Queue<Integer> firstPartQueue = new PriorityQueue<>(Collections.reverseOrder());
      Queue<Integer> secondPartQueue = new PriorityQueue<>();

      public MedianFinder() {

      }

      public void addNum(int num) {
         if (firstPartQueue.isEmpty()) {
            firstPartQueue.offer(num);
         } else if (firstPartQueue.size() == secondPartQueue.size()) {
            if (secondPartQueue.peek() <= num) {
               Integer poll = secondPartQueue.poll();
               secondPartQueue.offer(num);
               firstPartQueue.offer(poll);
            } else {
               firstPartQueue.offer(num);
            }
         } else {
            if (firstPartQueue.peek() < num) {
               secondPartQueue.offer(num);
            } else {
               Integer poll = firstPartQueue.poll();
               secondPartQueue.offer(poll);
               firstPartQueue.offer(num);
            }
         }
      }

      public double findMedian() {
         if (firstPartQueue.size() == secondPartQueue.size()) {
            return (firstPartQueue.peek() + secondPartQueue.peek()) / 2.0;
         } else {
            return firstPartQueue.peek();
         }
      }
   }
}
