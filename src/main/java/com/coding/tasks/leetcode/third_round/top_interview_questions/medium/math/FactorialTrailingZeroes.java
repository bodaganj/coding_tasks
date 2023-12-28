package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.math;

import java.math.BigInteger;

public class FactorialTrailingZeroes {

   public static void main(String[] args) {
      System.out.println(trailingZeroes(13));
   }

   public static int trailingZeroes(int n) {
      BigInteger sum = BigInteger.valueOf(1);
      int index = 1;
      while (index <= n) {
         sum = sum.multiply(BigInteger.valueOf(index));
         index++;
      }
      int counter = 0;
      while (sum.divideAndRemainder(BigInteger.valueOf(10))[1].equals(BigInteger.valueOf(0))) {
         counter++;
         sum = sum.divideAndRemainder(BigInteger.valueOf(10))[0];
      }
      return counter;
   }
}
