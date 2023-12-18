package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.sorting.and.searching;

public class FirstBadVersion {

   public static void main(String[] args) {

   }

   public static int firstBadVersion(int n) {
      return rec(0, n);
   }

   private static int rec(int start, int finish) {
      int mid = start + (finish - start) / 2;

      if (isBadVersion(mid) && !isBadVersion(mid - 1)) {
         return mid;
      } else if (!isBadVersion(mid)) {
         return rec(mid + 1, finish);
      } else {
         return rec(start, mid - 1);
      }
   }

   private static boolean isBadVersion(int version) {
      return true;
   }
}
