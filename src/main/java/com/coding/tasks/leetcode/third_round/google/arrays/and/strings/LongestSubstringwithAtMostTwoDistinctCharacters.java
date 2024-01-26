package com.coding.tasks.leetcode.third_round.google.arrays.and.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostTwoDistinctCharacters {

   public static void main(String[] args) {
      System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
      System.out.println(lengthOfLongestSubstringTwoDistinct("ccaabbb"));
   }

   public static int lengthOfLongestSubstringTwoDistinct(String s) {
      int longest = 0;

      int right = 0;
      int left = 0;
      Map<Character, Integer> map = new HashMap<>();
      while (right < s.length()) {
         char currChar = s.charAt(right);
         if (map.isEmpty() || map.containsKey(currChar) || map.keySet().size() < 2) {
            map.put(currChar, map.getOrDefault(currChar, 0) + 1);
            longest = Math.max(longest, right - left + 1);
         } else {
            map.put(currChar, 1);
            while (map.size() == 3) {
               char charAtLeft = s.charAt(left);
               if (map.get(charAtLeft) == 1) {
                  map.remove(charAtLeft);
               } else {
                  map.put(charAtLeft, map.get(charAtLeft) - 1);
               }
               left++;
            }
         }
         right++;
      }

      return longest;
   }
}
