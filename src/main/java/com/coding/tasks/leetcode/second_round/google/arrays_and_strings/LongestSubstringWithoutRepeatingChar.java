package com.coding.tasks.leetcode.second_round.google.arrays_and_strings;

import java.util.HashSet;
import java.util.Set;

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
      Set<Character> mapping = new HashSet<>();
      char[] chars = s.toCharArray();
      int max = 0;
      for (char aChar : chars) {
         while (mapping.contains(aChar)) {
            mapping.remove(chars[left]);
            left++;
         }

         mapping.add(aChar);
         max = Math.max(max, mapping.size());
      }

      return max;
   }
}
