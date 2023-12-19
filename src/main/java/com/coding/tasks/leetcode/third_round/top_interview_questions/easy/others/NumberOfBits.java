package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.others;

public class NumberOfBits {

   public static void main(String[] args) {
      System.out.println(hammingWeight(11));
   }

   public static int hammingWeight(int n) {
      if (n == 0) {
         return 0;
      }
      if (n < 0) {
         n = n * (-1);
      }
      int count = 0;
      while (n != 0) {
         int tmp = n ^ 1;
         if (tmp < n) {
            count++;
         }
         n = tmp >> 1;
      }
      return count;
   }
}
