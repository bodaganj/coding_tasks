package com.coding.tasks.leetcode.first_round.top_interview_questions.easy.string;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

   public static void main(String[] args) {
      System.out.println(isAnagram("anagram", "naragam"));
      System.out.println(isAnagram("rat", "car"));
   }

   private static boolean isAnagram(String first, String second) {
      Map<Character, Integer> firstMapping = getMapping(first);
      Map<Character, Integer> secondMapping = getMapping(second);

      return firstMapping.equals(secondMapping);
   }

   private static Map<Character, Integer> getMapping(String input) {
      Map<Character, Integer> mapping = new HashMap<>();
      for (char value : input.toCharArray()) {
         mapping.put(value, mapping.getOrDefault(value, 0) + 1);
      }
      return mapping;
   }
}
