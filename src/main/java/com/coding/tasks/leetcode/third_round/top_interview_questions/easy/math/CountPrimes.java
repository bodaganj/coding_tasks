package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.math;

public class CountPrimes {

   public static void main(String[] args) {

   }

   public static int countPrimes(int n) {
      if (n <= 2) {
         return 0;
      }
      int[] arr = new int[n];
      int count = 0;
      int index = 2;
      while (index < arr.length) {
         if (arr[index] == 0) {
            count++;
            int j = index + index;
            while (j < arr.length) {
               if (arr[j] == 0) {
                  arr[j] = 1;
               }
               j += index;
            }
         }
         index++;
      }
      return count;
   }
}
