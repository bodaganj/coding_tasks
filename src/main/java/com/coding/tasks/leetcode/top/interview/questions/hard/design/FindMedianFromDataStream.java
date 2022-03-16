package com.coding.tasks.leetcode.top.interview.questions.hard.design;

public class FindMedianFromDataStream {

   public static void main(String[] args) {
      MedianFinder obj1 = new MedianFinder();
      obj1.addNum(6);
      System.out.println(obj1.findMedian()); // 6
      obj1.addNum(10);
      System.out.println(obj1.findMedian()); // 8
      obj1.addNum(2);
      System.out.println(obj1.findMedian()); // 6
      obj1.addNum(6);
      System.out.println(obj1.findMedian()); // 6
      obj1.addNum(5);
      System.out.println(obj1.findMedian()); // 6

      MedianFinder obj2 = new MedianFinder();
      obj2.addNum(0);
      obj2.addNum(0);
      System.out.println(obj2.findMedian());

      MedianFinder obj3 = new MedianFinder();
      obj3.addNum(-1);
      System.out.println(obj3.findMedian());
      obj3.addNum(-2);
      System.out.println(obj3.findMedian());
   }

   /**
    * Your MedianFinder object will be instantiated and called as such:
    * MedianFinder obj = new MedianFinder();
    * obj.addNum(num);
    * double param_2 = obj.findMedian();
    */
   static class MedianFinder {

      public MedianFinder() {

      }

      public void addNum(int num) {

      }

      public double findMedian() {
         return 2.0;
      }
   }
}
