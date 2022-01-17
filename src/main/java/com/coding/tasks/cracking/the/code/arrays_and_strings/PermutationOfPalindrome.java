package com.coding.tasks.cracking.the.code.arrays_and_strings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PermutationOfPalindrome {

   public static void main(String[] args) {
      System.out.println(isPermutation("tactcoa"));
      System.out.println(isPermutation("madma"));
      System.out.println(isPermutation("mama"));
      System.out.println(isPermutation("mamazd"));
      System.out.println(isPermutation("bogdan"));
   }

   private static boolean isPermutation(String input) {
      Map<Character, Integer> map = new HashMap<>();

      List<Character> chars = input.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
      for (Character aChar : chars) {
         map.put(aChar, map.getOrDefault(aChar, 0) + 1);
      }

      Stream<Map.Entry<Character, Integer>> stream = map.entrySet().stream();
      if (input.length() % 2 == 0) {
         return stream.noneMatch(entry -> entry.getValue() % 2 != 0);
      } else {
         return stream.filter(entry -> entry.getValue() % 2 != 0).count() == 1;
      }
   }
}
