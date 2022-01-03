package com.coding.tasks.leetcode.amazon.arrays_and_strings;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class FindUniqueCharacterInAString {

   public static void main(String[] args) {
      System.out.println(firstUniqueChar("leetcode"));
      System.out.println(firstUniqueChar("loveleetcode"));
      System.out.println(firstUniqueChar("aabb"));
   }

   private static int firstUniqueChar(String s) {
      Map<Character, Integer> mapping = new LinkedHashMap<>();
      for (char aChar : s.toCharArray()) {
         mapping.put(aChar, mapping.getOrDefault(aChar, 0) + 1);
      }

      Optional<Map.Entry<Character, Integer>> first = mapping.entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst();
      return first.map(characterIntegerEntry -> s.indexOf(characterIntegerEntry.getKey())).orElse(-1);
   }

//   private static int firstUniqueChar1(String s) {
//      Map<Character, Integer> mapping = new LinkedHashMap<>();
//      Set<Character> seen = new HashSet<>();
//
//      char[] chars = s.toCharArray();
//      for (int i = 0; i < chars.length; i++) {
//         char element = chars[i];
//         if (seen.contains(element)) {
//            mapping.remove(element);
//         } else {
//            seen.add(element);
//            mapping.put(element, i);
//         }
//      }
//
//      return mapping.isEmpty() ? -1 : mapping.values().stream().findFirst().get();
//   }
}
