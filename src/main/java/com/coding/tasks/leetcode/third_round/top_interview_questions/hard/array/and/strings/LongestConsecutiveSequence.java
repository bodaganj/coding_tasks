package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.array.and.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {

   public static void main(String[] args) {
      System.out.println(longestConsecutive(new int[]{100, 1, 200, 2, 3, 4}));
      System.out.println(longestConsecutive(new int[]{0, -1}));
   }

   public static int longestConsecutive(int[] nums) {
      Set<Integer> all = new HashSet<>();
      for (int num : nums) {
         all.add(num);
      }
      int max = 0;
      Set<Integer> seen = new HashSet<>();
      for (int num : nums) {
         if (!seen.contains(num)) {
            seen.add(num);
            int left = num - 1;
            int right = num + 1;
            int count = 1;
            while ((all.contains(left) && !seen.contains(left)) || (all.contains(right) && !seen.contains(right))) {
               if (all.contains(left) && !seen.contains(left)) {
                  count++;
                  seen.add(left);
                  left--;
               }
               if (all.contains(right) && !seen.contains(right)) {
                  count++;
                  seen.add(right);
                  right++;
               }
            }
            max = Math.max(max, count);
         }
      }
      return max;
   }

   public static int longestConsecutive11(int[] nums) {
      if (nums.length == 0) {
         return 0;
      }
      Map<Integer, Integer> mapping = new HashMap<>();
      boolean change = true;
      while (change) {
         Set<Integer> seen = new HashSet<>();
         change = false;
         for (int num : nums) {
            if (!seen.contains(num)) {
               seen.add(num);
               if (mapping.containsKey(num - 1)) {
                  if (!mapping.containsKey(num) || mapping.get(num - 1) + 1 > mapping.get(num)) {
                     change = true;
                     mapping.put(num, mapping.get(num - 1) + 1);
                  }
               } else {
                  if (!mapping.containsKey(num)) {
                     change = true;
                     mapping.put(num, 0);
                  }
               }
            }
         }
      }

      int max = 0;
      for (Integer value : mapping.values()) {
         max = Math.max(max, value);
      }
      return max + 1;
   }
}