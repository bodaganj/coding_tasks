package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.array_and_strings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutCharacters {

   public static void main(String[] args) {
      System.out.println(lengthOfLongestSubstring("abcabcbb"));
      System.out.println(lengthOfLongestSubstring("bbbbb"));
      System.out.println(lengthOfLongestSubstring("pwwkew"));
      System.out.println(lengthOfLongestSubstring(" "));
   }

   private static int lengthOfLongestSubstring(String s) {
      if (s == null || s.isEmpty()) {
         return 0;
      }

      char[] chars = s.toCharArray();
      int max = 0;
      Set<Character> set = new HashSet<>();

      int j = 0;
      int i = 0;
      while (i < s.length()) {
         if (set.contains(chars[i])) {
            while (set.contains(chars[i])) {
               set.remove(chars[j]);
               j++;
            }
         }
         set.add(chars[i]);
         max = Math.max(max, set.size());
         i++;
      }

      return max;
   }
}
