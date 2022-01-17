package com.coding.tasks.cracking.the.code.arrays_and_strings;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class StringUniqueCharacters {

   public static void main(String[] args) {
      System.out.println(isUniqueString("abcd"));
      System.out.println(isUniqueStringNoDataStructures("abcd"));
      System.out.println(isUniqueString("abacd"));
      System.out.println(isUniqueStringNoDataStructures("abacd"));
   }

   /**
    * Determine if a string has all unique characters.
    * What if you cannot use additional data structures?
    * @param input
    * @return true if this is unique string
    */
   private static boolean isUniqueString(String input) {
      Set<Character> set = new HashSet<>();

      for (Character character : input.chars().mapToObj(c -> (char) c).collect(Collectors.toList())) {
         if (!set.add(character)) {
            return false;
         }
      }

      return true;
   }

   private static boolean isUniqueStringNoDataStructures(String input) {
      for (int i = 0; i < input.length(); i++) {
         if ((input.substring(0, i) + input.substring(i + 1)).contains(String.valueOf(input.charAt(i)))) {
            return false;
         }
      }
      return true;
   }
}
