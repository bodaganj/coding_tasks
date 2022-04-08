package com.coding.tasks.leetcode.first_round.top_interview_questions.easy.string;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FirstUniqueCharacterInString {

   public static void main(String[] args) {
      System.out.println(firstUniqueChar("leetcode"));
      System.out.println(firstUniqueChar("loveleetcode"));
      System.out.println(firstUniqueChar("aabb"));
      System.out.println(firstUniqueChar("aadadaad"));
   }

   private static int firstUniqueChar(String s) {
      Map<Character, Integer> mapping = new LinkedHashMap<>();
      Set<Character> seen = new HashSet<>();

      char[] chars = s.toCharArray();
      for (int i = 0; i < chars.length; i++) {
         char element = chars[i];
         if (seen.contains(element)) {
            mapping.remove(element);
         } else {
            seen.add(element);
            mapping.put(element, i);
         }
      }

      return mapping.isEmpty() ? -1 : mapping.values().stream().findFirst().get();
   }
}
