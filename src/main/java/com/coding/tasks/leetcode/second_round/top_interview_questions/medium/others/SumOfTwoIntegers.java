package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.others;

public class SumOfTwoIntegers {

   public static void main(String[] args) {
      System.out.println(getSum(2, 3));
      System.out.println(getSum(1, 7));
   }

   private static int getSum(int a, int b) {
      while ((a & b) != 0) {
         int tmp = a ^ b;
         b = (a & b) << 1;
         a = tmp;
      }

      return b ^ a;
   }
}
