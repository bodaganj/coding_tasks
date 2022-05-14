package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.math;

public class SqrtX {

   public static void main(String[] args) {
      System.out.println(mySqrt(36));
      System.out.println(mySqrt(0));
      System.out.println(mySqrt(1));
      System.out.println(mySqrt(4));
      System.out.println(mySqrt(2));
      System.out.println(mySqrt(8));
      System.out.println(mySqrt(81));
      System.out.println(mySqrt(80));
      System.out.println(mySqrt(2147395599));
   }

   private static int mySqrt(int x) {
      if (x < 2) {
         return x;
      }

      long num;
      int left = 2;
      int right = x / 2;

      while (left <= right) {
         int mid = left + (right - left) / 2;
         num = (long) mid * mid;
         if (num > x) {
            right = mid - 1;
         } else if (num < x) {
            left = mid + 1;
         } else {
            return mid;
         }
      }

      return right;
   }
}
