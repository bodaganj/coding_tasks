package com.coding.tasks.leetcode.second_round.amazon.arrays_and_strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutCharacters {

   public static void main(String[] args) {
      System.out.println(lengthOfLongestSubstring("abcabcbb"));
      System.out.println(lengthOfLongestSubstring("bbbbb"));
      System.out.println(lengthOfLongestSubstring("pwwkew"));
      System.out.println(lengthOfLongestSubstring(" "));
   }

   private static int lengthOfLongestSubstring(String s) {
      int max = 0;
      int left = 0;
      Map<Character, Integer> map = new HashMap<>();
      for (char c : s.toCharArray()) {
         max = Math.max(max, map.size());
         while (map.containsKey(c)) {
            map.remove(s.charAt(left));
            left++;
         }
         map.put(c, map.getOrDefault(c, 0) + 1);
      }
      max = Math.max(max, map.size());
      return max;
   }
}
