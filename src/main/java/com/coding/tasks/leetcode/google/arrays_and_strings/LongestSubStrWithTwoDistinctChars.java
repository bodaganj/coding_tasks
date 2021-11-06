package com.coding.tasks.leetcode.google.arrays_and_strings;

import java.util.LinkedList;

public class LongestSubStrWithTwoDistinctChars {

   public static void main(String[] args) {
      System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
      System.out.println(lengthOfLongestSubstringTwoDistinct("ccaabbb"));
   }

   private static int lengthOfLongestSubstringTwoDistinct(String s) {
      int max = 0;
      LinkedList<Character> currentChars = new LinkedList<>();
      int currentLength = 0;

      char[] chars = s.toCharArray();
      for (char character : chars) {
         if (currentChars.isEmpty() || currentChars.contains(character) || currentChars.stream().distinct().count() < 2) {
            currentChars.add(character);
            currentLength++;
            max = Math.max(max, currentLength);
         } else {
            max = Math.max(max, currentLength);
            currentChars.add(character);
            while (currentChars.stream().distinct().count() != 2) {
               currentChars.removeFirst();
            }
            currentLength = currentChars.size();
         }
      }

      return max;
   }
}
