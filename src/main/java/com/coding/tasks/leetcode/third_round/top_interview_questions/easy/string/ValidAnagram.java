package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.string;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

   public boolean isAnagram(String s, String t) {
      if (s.length() != t.length()) {
         return false;
      }
      Map<Character, Integer> sMapping = new HashMap<>();
      for (char c : s.toCharArray()) {
         if (sMapping.containsKey(c)) {
            sMapping.put(c, sMapping.get(c) + 1);
         } else {
            sMapping.put(c, 1);
         }
      }

      for (char c : t.toCharArray()) {
         if (sMapping.containsKey(c)) {
            if (sMapping.get(c) == 1) {
               sMapping.remove(c);
            } else {
               sMapping.put(c, sMapping.get(c) - 1);
            }
         } else {
            return false;
         }
      }

      return true;
   }
}
