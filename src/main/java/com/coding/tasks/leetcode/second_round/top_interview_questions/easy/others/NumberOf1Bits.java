package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.others;

public class NumberOf1Bits {

   public static void main(String[] args) {
      System.out.println(hammingWeight(4));
      System.out.println(hammingWeight(7));
      System.out.println(hammingWeight(-3));
   }

   private static int hammingWeight(int n) {
      int counter = 0;
      while (n != 0) {
         int b = n ^ 1;
         if (n > b) {
            counter++;
         }
         b >>>= 1;
         n = b;
      }
      return counter;
   }
}
