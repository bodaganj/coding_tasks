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

      Map<Character, Integer> firstMapping = new HashMap<>();
      for (char letter : s.toCharArray()) {
         firstMapping.put(letter, firstMapping.getOrDefault(letter, 0) + 1);
      }

      Map<Character, Integer> secondMapping = new HashMap<>();
      for (char letter : t.toCharArray()) {
         secondMapping.put(letter, secondMapping.getOrDefault(letter, 0) + 1);
      }

      if (!firstMapping.keySet().equals(secondMapping.keySet())) {
         return false;
      }

      for (Map.Entry<Character, Integer> characterIntegerEntry : firstMapping.entrySet()) {
         Character key = characterIntegerEntry.getKey();
         if (!firstMapping.get(key).equals(secondMapping.get(key))) {
            return false;
         }
      }

      return true;
   }
}
