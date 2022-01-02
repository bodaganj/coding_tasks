package com.coding.tasks.leetcode.amazon.arrays_and_strings;

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
      String shortest = "";

      Map<Character, Integer> tMapping = new HashMap<>();
      for (char aChar : t.toCharArray()) {
         tMapping.put(aChar, tMapping.getOrDefault(aChar, 0) + 1);
      }

      int slow = 0;
      int fast = 0;
      boolean makeBigger = true;
      while (fast <= s.length() && slow <= s.length() - t.length()) {
         if (makeBigger) {
            if (fast == s.length()) {
               makeBigger = false;
            } else if (isValidSubstring(s.substring(slow, fast + 1), tMapping)) {
               fast++;
               makeBigger = false;
               if (shortest.isBlank() || shortest.length() > s.substring(slow, fast).length()) {
                  shortest = s.substring(slow, fast);
               }
            } else {
               fast++;
            }
         } else {
            if (isValidSubstring(s.substring(slow + 1, fast), tMapping)) {
               slow++;
               if (shortest.isBlank() || shortest.length() > s.substring(slow, fast).length()) {
                  shortest = s.substring(slow, fast);
               }
            } else {
               makeBigger = true;
               slow++;
            }
         }
      }

      return shortest;
   }

   private static boolean isValidSubstring(String sub, Map<Character, Integer> tMapping) {
      Map<Character, Integer> subMapping = new HashMap<>();
      for (char aChar : sub.toCharArray()) {
         subMapping.put(aChar, subMapping.getOrDefault(aChar, 0) + 1);
      }

      for (Map.Entry<Character, Integer> entry : tMapping.entrySet()) {
         if (!subMapping.containsKey(entry.getKey()) || subMapping.get(entry.getKey()) < tMapping.get(entry.getKey())) {
            return false;
         }
      }
      return true;
   }
}
