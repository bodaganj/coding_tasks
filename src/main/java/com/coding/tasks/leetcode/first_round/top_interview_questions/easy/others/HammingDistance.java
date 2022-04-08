package com.coding.tasks.leetcode.first_round.top_interview_questions.easy.others;

public class HammingDistance {

   public static void main(String[] args) {
      System.out.println(hammingDistance(3, 1));
      System.out.println(hammingDistance(4, 1));
   }

   private static int hammingDistance(int x, int y) {
      int xor = x ^ y;

      int count = 0;
      while (xor != 0) {
         count++;
         xor &= (xor - 1);
      }

      return count;
   }
}
