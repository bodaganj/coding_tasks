package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.array.and.string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

   public static void main(String[] args) {
      System.out.println(lengthOfLongestSubstring("abcabcbb"));
      System.out.println(lengthOfLongestSubstring("bbbbb"));
      System.out.println(lengthOfLongestSubstring("pwwkew"));
   }

   public static int lengthOfLongestSubstring(String s) {
      Set<Character> set = new HashSet<>();
      int right = 0;
      int left = 0;
      int longestSubstring = 0;

      while (right < s.length()) {
         char currentRight = s.charAt(right);
         if (set.contains(currentRight)) {
            longestSubstring = Math.max(longestSubstring, set.size());
            while (s.charAt(left) != currentRight) {
               set.remove(s.charAt(left));
               left++;
            }
            set.remove(s.charAt(left));
            left++;
         }
         set.add(currentRight);
         right++;
      }
      longestSubstring = Math.max(longestSubstring, set.size());

      return longestSubstring;
   }
}
