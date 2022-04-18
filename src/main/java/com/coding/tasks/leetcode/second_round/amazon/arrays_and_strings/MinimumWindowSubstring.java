package com.coding.tasks.leetcode.second_round.amazon.arrays_and_strings;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

   public static void main(String[] args) {
      System.out.println(minWindow("ADOBECODEBANC", "ABC"));
      System.out.println(minWindow("bdab", "ab"));
      System.out.println(minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));
      System.out.println(minWindow("a", "a"));
      System.out.println(minWindow("cabwefgewcwaefgcf", "cae"));
   }

   private static String minWindow(String s, String t) {
      String min = "";
      if (t.length() > s.length()) {
         return min;
      }

      Map<Character, Integer> mapping = new HashMap<>();
      for (char aChar : t.toCharArray()) {
         mapping.put(aChar, mapping.getOrDefault(aChar, 0) + 1);
      }

      int minLength = Integer.MAX_VALUE;
      int left = 0;
      int right = 0;
      Map<Character, Integer> inputMapping = new HashMap<>();
      while (right < s.length()) {
         char curr = s.charAt(right);
         if (mapping.containsKey(curr)) {
            inputMapping.put(curr, inputMapping.getOrDefault(curr, 0) + 1);
         }

         while (isNeededSubstring(inputMapping, mapping) && left <= right) {
            if (minLength > right - left) {
               minLength = right - left;
               min = s.substring(left, right + 1);
            }

            if (mapping.containsKey(s.charAt(left))) {
               inputMapping.put(s.charAt(left), inputMapping.get(s.charAt(left)) - 1);
               if (inputMapping.get(s.charAt(left)) == 0) {
                  inputMapping.remove(s.charAt(left));
               }
            }

            left++;
         }

         right++;
      }

      return min;
   }

   private static boolean isNeededSubstring(Map<Character, Integer> inputMapping, Map<Character, Integer> mapping) {
      if (!inputMapping.keySet().equals(mapping.keySet())) {
         return false;
      }
      for (Map.Entry<Character, Integer> entry : inputMapping.entrySet()) {
         if (inputMapping.get(entry.getKey()) < mapping.get(entry.getKey())) {
            return false;
         }
      }

      return true;
   }
}
