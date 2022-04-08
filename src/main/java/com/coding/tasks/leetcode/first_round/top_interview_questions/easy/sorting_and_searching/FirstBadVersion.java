package com.coding.tasks.leetcode.first_round.top_interview_questions.easy.sorting_and_searching;

public class FirstBadVersion {

   private static int firstBadVersion(int n) {
      int left = 1;
      int right = n;

      while (left <= right) {
         int middle = left + (right - left) / 2;

         if (isBadVersion(middle)) {
            if (middle - 1 == 0) {
               return middle;
            } else if (isBadVersion(middle - 1)) {
               right = middle - 1;
            } else {
               return middle;
            }
         } else {
            if (isBadVersion(middle + 1)) {
               return middle + 1;
            } else {
               left = middle + 1;
            }
         }
      }

      return n;
   }

   private static boolean isBadVersion(int n) {
      return true;
   }
}
