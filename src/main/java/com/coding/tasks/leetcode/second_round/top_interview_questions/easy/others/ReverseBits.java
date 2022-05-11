package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.others;

public class ReverseBits {

   public static void main(String[] args) {
      System.out.println(reverseBits(4));
      System.out.println("=====");
      System.out.println(reverseBits(7));
   }

   private static int reverseBits(int n) {
      int ans = 0;
      for (int i = 0; i < 32; i++) {
         ans <<= 1;
         if ((n & 1) == 1) {
            ans ^= 1;
         }
         n >>>= 1;
      }

      return ans;
   }
}
