package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.sorting_and_searching;

public class FirstBadVersion {

   private static int firstBadVersion(int n) {
      int left = 1;
      int right = n;

      while (left < right) {
         int mid = left + (right - left) / 2;
         if (isBadVersion(mid)) {
            right = mid;
         } else {
            left = mid + 1;
         }
      }
      return left;
   }

   private static boolean isBadVersion(int version) {
      return true;
   }
}
