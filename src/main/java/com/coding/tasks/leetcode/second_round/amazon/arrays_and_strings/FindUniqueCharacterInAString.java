package com.coding.tasks.leetcode.second_round.amazon.arrays_and_strings;

import java.util.HashMap;
import java.util.Map;

public class FindUniqueCharacterInAString {

   public static void main(String[] args) {
      System.out.println(firstUniqueChar("leetcode"));
      System.out.println(firstUniqueChar("loveleetcode"));
      System.out.println(firstUniqueChar("aabb"));
   }

   private static int firstUniqueChar(String s) {
      char[] chars = s.toCharArray();

      Map<Character, Integer> map = new HashMap<>();
      for (char aChar : chars) {
         map.put(aChar, map.getOrDefault(aChar, 0) + 1);
      }

      for (int i = 0; i < chars.length; i++) {
         if (map.get(chars[i]) < 2) {
            return i;
         }
      }

      return -1;
   }
}
