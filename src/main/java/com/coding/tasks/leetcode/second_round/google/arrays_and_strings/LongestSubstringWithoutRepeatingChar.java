package com.coding.tasks.leetcode.second_round.google.arrays_and_strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChar {

   public static void main(String[] args) {
      System.out.println(lengthOfLongestSubstring("abba"));
      System.out.println(lengthOfLongestSubstring("abcabcbb"));
      System.out.println(lengthOfLongestSubstring("bbbbb"));
      System.out.println(lengthOfLongestSubstring("pwwkew"));
      System.out.println(lengthOfLongestSubstring(""));
      System.out.println(lengthOfLongestSubstring(" "));
      System.out.println(lengthOfLongestSubstring("dvdf"));
   }

   private static int lengthOfLongestSubstring(String s) {
      int left = 0;
      int right = 0;
      Map<Character, Integer> mapping = new HashMap<>();
      char[] chars = s.toCharArray();
      int max = 0;
      while (right < chars.length) {
         if (mapping.containsKey(chars[right])) {
            while (mapping.containsKey(chars[right])) {
               mapping.put(chars[left], mapping.get(chars[left]) - 1);
               if (mapping.get(chars[left]) == 0) {
                  mapping.remove(chars[left]);
               }
               left++;
            }
         } else {
            mapping.put(chars[right], 1);
            right++;
         }
         max = Math.max(max, mapping.size());
      }

      return max;
   }
}
