package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.array.and.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {

   public static void main(String[] args) {
//      System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));
//      System.out.println(lengthOfLongestSubstringKDistinct("a", 0));
      System.out.println(lengthOfLongestSubstringKDistinct("abee", 1));
   }

   public static int lengthOfLongestSubstringKDistinct(String s, int k) {
      if (k == 0) {
         return 0;
      }
      int longest = 0;
      int left = 0;
      Map<Character, Integer> mapping = new HashMap<>();
      int currMax = 0;
      for (char c : s.toCharArray()) {
         if (mapping.containsKey(c) || mapping.keySet().size() < k) {
            mapping.put(c, mapping.getOrDefault(c, 0) + 1);
         } else {
            longest = Math.max(longest, currMax);
            while (mapping.size() == k) {
               char curr = s.charAt(left);
               if (mapping.get(curr) == 1) {
                  mapping.remove(curr);
               } else {
                  mapping.put(curr, mapping.get(curr) - 1);
               }
               currMax--;
               left++;
            }
            mapping.put(c, 1);
         }
         currMax++;
      }
      longest = Math.max(longest, currMax);
      return longest;
   }
}
