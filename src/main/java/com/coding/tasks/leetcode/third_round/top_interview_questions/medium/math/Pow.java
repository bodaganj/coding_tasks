package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.math;

import java.math.BigDecimal;

public class Pow {

   public static void main(String[] args) {
      System.out.println(myPow(2, -2147483648));
   }

   public static double myPow(double x, int n) {
      if (n == 0) {
         return 1;
      }
      if (x == 1) {
         return 1;
      }
      if (x == -1) {
         if (n % 2 == 0) {
            return 1;
         } else {
            return -1;
         }
      }
      if (n == Integer.MIN_VALUE) {
         return 0;
      }
      double mult = x;
      int index = 1;
      while (index < Math.abs(n)) {
         mult *= x;
         index++;
      }

      return n > 0 ? mult : 1 / mult;
   }

   public double myPow1(double x, int n) {
      if (n == 0) {
         return 1;
      }
      if (x == 1) {
         return 1;
      }
      BigDecimal mult = BigDecimal.valueOf(x);
      int index = 1;
      while (index < Math.abs(n)) {
         mult = mult.multiply(BigDecimal.valueOf(x));
         index++;
      }

      return n > 0 ? mult.doubleValue() : BigDecimal.valueOf(1).divide(mult).doubleValue();
   }
}
