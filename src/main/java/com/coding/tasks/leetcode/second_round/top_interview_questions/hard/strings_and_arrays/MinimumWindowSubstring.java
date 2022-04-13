package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.strings_and_arrays;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

   public static void main(String[] args) {
      System.out.println(minWindow("ADOBECODEBANC", "ABC"));
   }

   private static String minWindow(String s, String t) {
      if (s == null || t == null || s.length() * t.length() == 0) {
         return "";
      }
      Map<Character, Integer> secondMapping = new HashMap<>();
      for (char aChar : t.toCharArray()) {
         secondMapping.put(aChar, secondMapping.getOrDefault(aChar, 0) + 1);
      }

      String minWindow = "";
      Map<Character, Integer> firstMapping = new HashMap<>();
      char[] chars = s.toCharArray();
      int left = 0;
      int right = 0;
      while (right < chars.length) {
         char curr = chars[right];
         if (secondMapping.containsKey(curr)) {
            firstMapping.put(curr, firstMapping.getOrDefault(curr, 0) + 1);

            while (isMappingEqual(firstMapping, secondMapping)) {
               String substring = s.substring(left, right + 1);
               if (minWindow.equals("") || substring.length() < minWindow.length()) {
                  minWindow = substring;
               }

               if (secondMapping.containsKey(chars[left])) {
                  firstMapping.put(chars[left], firstMapping.get(chars[left]) - 1);
                  if (firstMapping.get(chars[left]) == 0) {
                     firstMapping.remove(chars[left]);
                  }
               }
               left++;
            }
         }
         right++;
      }

      while (firstMapping.equals(secondMapping)) {
         String substring = s.substring(left, right + 1);
         if (minWindow.equals("") || substring.length() < minWindow.length()) {
            minWindow = substring;
         }

         firstMapping.put(chars[left], firstMapping.get(chars[left]) - 1);
         if (firstMapping.get(chars[left]) == 0) {
            firstMapping.remove(chars[left]);
         }
         left++;
      }

      return minWindow;
   }

   private static boolean isMappingEqual(Map<Character, Integer> firstMapping, Map<Character, Integer> secondMapping) {
      if (!firstMapping.keySet().equals(secondMapping.keySet())) {
         return false;
      }

      for (Map.Entry<Character, Integer> entry : firstMapping.entrySet()) {
         if (entry.getValue() < secondMapping.get(entry.getKey())) {
            return false;
         }
      }

      return true;
   }
}
