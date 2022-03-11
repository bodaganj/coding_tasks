package com.coding.tasks.leetcode.top.interview.questions.medium.others;

public class SumOfTwoIntegers {

   public static void main(String[] args) {

   }

   private static int getSum(int a, int b) {
      while (b != 0) {
         int ans = a ^ b;
         int carry = (a & b) << 1;
         a = ans;
         b = carry;
      }
      return a;
   }
}
