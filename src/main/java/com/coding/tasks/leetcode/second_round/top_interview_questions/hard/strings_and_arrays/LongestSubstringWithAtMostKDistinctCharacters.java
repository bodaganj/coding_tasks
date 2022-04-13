package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.strings_and_arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {

   public static void main(String[] args) {
      System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));
      System.out.println(lengthOfLongestSubstringKDistinct("aa", 1));
      System.out.println(lengthOfLongestSubstringKDistinct("a", 0));
   }

   private static int lengthOfLongestSubstringKDistinct(String s, int k) {
      int max = 0;
      if (s == null || s.isEmpty()) {
         return max;
      }
      if (k == 0) {
         return 0;
      }

      Map<Character, Integer> mapping = new HashMap<>();
      char[] chars = s.toCharArray();
      int left = 0;
      int right = 0;

      while (right < chars.length) {
         char aChar = chars[right];
         if (mapping.size() < k || mapping.containsKey(aChar)) {
            mapping.put(aChar, mapping.getOrDefault(aChar, 0) + 1);
            right++;
         } else {
            mapping.put(chars[left], mapping.get(chars[left]) - 1);
            if (mapping.get(chars[left]) == 0) {
               mapping.remove(chars[left]);
            }
            left++;
         }
         max = Math.max(max, mapping.values().stream().mapToInt(Integer::intValue).sum());
      }

      return max;
   }
}
