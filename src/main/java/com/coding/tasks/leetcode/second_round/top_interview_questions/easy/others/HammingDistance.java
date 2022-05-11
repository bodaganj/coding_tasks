package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.others;

public class HammingDistance {

   public static void main(String[] args) {
      System.out.println(hammingDistance(3, 1));
      System.out.println(hammingDistance(4, 1));
   }

   private static int hammingDistance(int x, int y) {
      int dif = x ^ y;

      int count = 0;
      while (dif != 0) {
         count++;
         dif &= (dif - 1);
      }

      return count;
   }
}
