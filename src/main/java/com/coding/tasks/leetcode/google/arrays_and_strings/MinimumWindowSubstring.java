package com.coding.tasks.leetcode.google.arrays_and_strings;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

   public static void main(String[] args) {
      System.out.println(minWindow("ADOBECODEBANC", "ABC"));
      System.out.println(minWindow("a", "a"));
      System.out.println(minWindow("a", "b"));
      System.out.println(minWindow("cabwefgewcwaefgcf", "cae"));
   }

   private static String minWindow(String input, String target) {
      int inputLength = input.length();
      String smallestSubstring = "";
      if (target.length() > inputLength) {
         return smallestSubstring;
      }

      Map<Character, Integer> targetMapping = new HashMap<>();
      for (char aChar : target.toCharArray()) {
         targetMapping.put(aChar, targetMapping.getOrDefault(aChar, 0) + 1);
      }

      int left = 0;
      int right = 0;
      Map<Character, Integer> currentMapping = new HashMap<>();
      while (right <= inputLength) {
         if (isCorrectSubstring(targetMapping, currentMapping)) {
            if (smallestSubstring.isBlank() || smallestSubstring.length() > right - left) {
               smallestSubstring = input.substring(left, right);
            }
            char currentLeft = input.charAt(left);
            if (currentMapping.containsKey(currentLeft)) {
               currentMapping.put(currentLeft, currentMapping.get(currentLeft) - 1);
               if (currentMapping.get(currentLeft) == 0) {
                  currentMapping.remove(currentLeft);
               }
            }
            left++;
         } else {
            if (right != inputLength) {
               char currentChar = input.charAt(right);
               if (targetMapping.containsKey(currentChar)) {
                  currentMapping.put(currentChar, currentMapping.getOrDefault(currentChar, 0) + 1);
               }
            }
            right++;
         }
      }
      return smallestSubstring;
   }

   private static boolean isCorrectSubstring(Map<Character, Integer> targetMapping, Map<Character, Integer> currentMapping) {
      if (!targetMapping.keySet().equals(currentMapping.keySet())) {
         return false;
      }

      for (Map.Entry<Character, Integer> entry : targetMapping.entrySet()) {
         if (entry.getValue() > currentMapping.get(entry.getKey())) {
            return false;
         }
      }
      return true;
   }
}
