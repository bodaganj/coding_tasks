package com.coding.tasks.leetcode.top.interview.questions.easy.others;

public class NumberOf1Bits {

   public static void main(String[] args) {
      System.out.println(hammingWeight(4));
      System.out.println(hammingWeight(7));
   }

   private static int hammingWeight(int n) {
      int count = 0;
      while (n != 0) {
         if ((n & 1) == 1) {
            count++;
         }
         n = n >> 1;
      }
      return count;
   }
}
