package com.coding.tasks.leetcode.first_round.top_interview_questions.hard.strings_and_arrays;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

   public static void main(String[] args) {
      System.out.println(minWindow("ADOBECODEBANC", "ABC"));
   }

   private static String minWindow(String first, String second) {
      String res = "";
      int fLength = first.length();
      int sLength = second.length();

      if (sLength > fLength) {
         return res;
      }

      Map<Character, Integer> secondMap = new HashMap<>();
      for (char aChar : second.toCharArray()) {
         secondMap.put(aChar, secondMap.getOrDefault(aChar, 0) + 1);
      }

      int left = 0;
      int right = 0;
      int minimum = Integer.MAX_VALUE;
      Map<Character, Integer> firstMap = new HashMap<>();
      while (right < fLength) {
         char charAt = first.charAt(right);

         if (secondMap.containsKey(charAt)) {
            firstMap.put(charAt, firstMap.getOrDefault(charAt, 0) + 1);

            if (isCorrect(firstMap, secondMap)) {
               while (isCorrect(firstMap, secondMap)) {
                  minimum = Math.min(minimum, right - left + 1);
                  if (right - left + 1 == minimum) {
                     res = first.substring(left, right + 1);
                  }

                  char leftChar = first.charAt(left);
                  if (firstMap.containsKey(leftChar)) {
                     firstMap.put(leftChar, firstMap.get(leftChar) - 1);
                     if (firstMap.get(leftChar) == 0) {
                        firstMap.remove(leftChar);
                     }
                  }

                  left++;
               }
            }
         }
         right++;
      }

      return res;
   }

   private static boolean isCorrect(Map<Character, Integer> firstMap, Map<Character, Integer> secondMap) {
      if (firstMap.keySet().size() != secondMap.keySet().size()) {
         return false;
      } else {
         for (Map.Entry<Character, Integer> entry : firstMap.entrySet()) {
            if (entry.getValue() < secondMap.get(entry.getKey())) {
               return false;
            }
         }
      }
      return true;
   }
}
