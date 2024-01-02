package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.array.and.strings;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

   public static void main(String[] args) {
      System.out.println(minWindow("ADOBECODEBANC", "ABC"));
      System.out.println(minWindow("A", "B"));
      System.out.println(minWindow("AB", "B"));
   }

   public static String minWindow(String s, String t) {
      if (t.length() > s.length()) {
         return "";
      }

      Map<Character, Integer> tMap = new HashMap<>();
      for (char c : t.toCharArray()) {
         tMap.put(c, tMap.getOrDefault(c, 0) + 1);
      }

      int resultLength = Integer.MAX_VALUE;
      int start = 0;
      int left = 0;
      int right = 0;
      Map<Character, Integer> sMap = new HashMap<>();
      while (right < s.length()) {
         char curr = s.charAt(right);
         if (tMap.containsKey(curr)) {
            sMap.put(curr, sMap.getOrDefault(curr, 0) + 1);

            while (isExpected(tMap, sMap) && left <= right) {
               if ((right - left + 1) < resultLength) {
                  start = left;
                  resultLength = right - left + 1;
               }
               if (sMap.containsKey(s.charAt(left))) {
                  if (sMap.get(s.charAt(left)) == 1) {
                     sMap.remove(s.charAt(left));
                  } else {
                     sMap.put(s.charAt(left), sMap.get(s.charAt(left)) - 1);
                  }
               }
               left++;
            }
         }
         right++;
      }

      if (resultLength == Integer.MAX_VALUE) {
         return "";
      }
      StringBuilder ans = new StringBuilder();
      for (int i = start; i < start + resultLength; i++) {
         ans.append(s.charAt(i));
      }
      return ans.toString();
   }

   private static boolean isExpected(Map<Character, Integer> tMap, Map<Character, Integer> sMap) {
      if (!sMap.keySet().equals(tMap.keySet())) {
         return false;
      }

      for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
         if (tMap.get(entry.getKey()) > sMap.get(entry.getKey())) {
            return false;
         }
      }
      return true;
   }
}
