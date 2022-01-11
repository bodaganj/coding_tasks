package com.coding.tasks.leetcode.top.interview.questions.hard.strings_and_arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {

   private static int lengthOfLongestSubstringKDistinct(String s, int k) {
      int max = 0;
      Map<Character, Integer> map = new HashMap<>();
      int right = 0;
      int left = 0;

      while (right < s.length()) {
         char cRight = s.charAt(right);
         if (map.containsKey(cRight) || map.size() < k) {
            map.put(cRight, map.getOrDefault(cRight, 0) + 1);
            right++;
            max = Math.max(max, right - left);
         } else {
            map.put(cRight, 1);
            right++;
            while (map.size() > k) {
               char cLeft = s.charAt(left);
               map.put(cLeft, map.get(cLeft) - 1);
               if (map.get(cLeft) == 0) {
                  map.remove(cLeft);
               }
               left++;
            }
         }
      }

      return max;
   }
}
