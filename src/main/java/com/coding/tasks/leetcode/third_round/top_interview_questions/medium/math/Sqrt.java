package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.math;

public class Sqrt {

   public static void main(String[] args) {
      System.out.println(mySqrt(2147483647));
      System.out.println(mySqrt(2147395600));
      System.out.println(mySqrt(2147395600));
   }

   public static int mySqrt(int x) {
      int i = 0;
      while (i * i <= x && i <= 46340) {
         i++;
      }
      return i - 1;
   }
}
