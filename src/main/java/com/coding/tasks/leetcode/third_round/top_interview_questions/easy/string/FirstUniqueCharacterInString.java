package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.string;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacterInString {

   public static int firstUniqChar(String s) {
      char[] chars = s.toCharArray();
      Map<Character, Integer> mapping = new LinkedHashMap<>();
      for (char c : chars) {
         if (mapping.containsKey(c)) {
            mapping.put(c, mapping.get(c) + 1);
         } else {
            mapping.put(c, 1);
         }
      }

      for (int i = 0; i < chars.length; i++) {
         if (mapping.get(chars[i]) == 1) {
            return i;
         }
      }

      return -1;
   }
}
