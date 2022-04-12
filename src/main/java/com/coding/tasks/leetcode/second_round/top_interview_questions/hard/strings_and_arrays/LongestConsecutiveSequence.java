package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.strings_and_arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

   public static void main(String[] args) {
      System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
      System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
   }

   private static int longestConsecutive(int[] nums) {
      Set<Integer> set = new HashSet<>();
      for (int num : nums) {
         set.add(num);
      }

      int longestStreak = 0;
      for (int num : set) {
         if (!set.contains(num - 1)) {
            int current = num;
            int currentStreak = 1;
            while (set.contains(current + 1)) {
               current++;
               currentStreak++;
            }

            longestStreak = Math.max(longestStreak, currentStreak);
         }
      }

      return longestStreak;
   }
}
