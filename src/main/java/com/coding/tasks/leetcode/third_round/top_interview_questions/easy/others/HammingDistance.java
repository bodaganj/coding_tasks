package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.others;

public class HammingDistance {

   public static void main(String[] args) {

   }

   public static int hammingDistance(int x, int y) {
      int tmp = x ^ y;
      int count = 0;
      while (tmp != 0) {
         count++;
         tmp &= (tmp - 1);
      }
      return count;
   }
}
