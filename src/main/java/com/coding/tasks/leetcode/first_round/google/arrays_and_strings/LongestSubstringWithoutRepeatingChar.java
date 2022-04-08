package com.coding.tasks.leetcode.first_round.google.arrays_and_strings;

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
      int ans = 0;
      Map<Character, Integer> map = new HashMap<>();
      for (int i = 0, j = 0; j < s.length(); j++) {
         char currentChar = s.charAt(j);

         if (map.containsKey(currentChar)) {
            i = Math.max(i, map.get(currentChar));
         }

         ans = Math.max(ans, j - i + 1);
         map.put(currentChar, j + 1);
      }
      return ans;
   }
}
