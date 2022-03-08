package com.coding.tasks.leetcode.google.sorting_and_searching;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

   private static ValidAnagram validAnagram = new ValidAnagram();

   public static void main(String[] args) {
      System.out.println(validAnagram.isAnagram("azaza", "zzaaa"));
      System.out.println(validAnagram.isAnagram("anagram", "nagaram"));
      System.out.println(validAnagram.isAnagram("rat", "car"));
   }

   public boolean isAnagram(String s, String t) {
      if (s.length() != t.length()) {
         return false;
      }

      Map<Character, Integer> mapping = new HashMap<>();
      for (char letter : s.toCharArray()) {
         mapping.put(letter, mapping.getOrDefault(letter, 0) + 1);
      }

      for (char letter : t.toCharArray()) {
         if (!mapping.containsKey(letter)) {
            return false;
         }
         int tmp = mapping.get(letter) - 1;
         if (tmp == 0) {
            mapping.remove(letter);
         } else {
            mapping.put(letter, tmp);
         }
      }

      return mapping.isEmpty();
   }
}
