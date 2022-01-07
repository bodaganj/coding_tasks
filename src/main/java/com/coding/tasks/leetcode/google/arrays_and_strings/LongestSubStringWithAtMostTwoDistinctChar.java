package com.coding.tasks.leetcode.google.arrays_and_strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithAtMostTwoDistinctChar {

   public static void main(String[] args) {
      System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
      System.out.println(lengthOfLongestSubstringTwoDistinct("ccaabbb"));
   }

   private static int lengthOfLongestSubstringTwoDistinct(String s) {
      if (s.length() < 3) {
         return s.length();
      }

      int max = 0;
      Map<Character, Integer> map = new HashMap<>();
      int right = 0;
      int left = 0;

      while (right < s.length()) {
         char cRight = s.charAt(right);
         if (map.containsKey(cRight) || map.size() < 2) {
            map.put(cRight, map.getOrDefault(cRight, 0) + 1);
            right++;
            max = Math.max(max, right - left);
         } else {
            map.put(cRight, 1);
            right++;
            while (map.size() > 2) {
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
