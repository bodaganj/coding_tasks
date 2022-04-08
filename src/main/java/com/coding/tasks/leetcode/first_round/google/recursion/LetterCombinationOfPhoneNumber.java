package com.coding.tasks.leetcode.first_round.google.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfPhoneNumber {

   private static Map<Character, List<String>> mapping = Map.of(
      '2', List.of("a", "b", "c"),
      '3', List.of("d", "e", "f"),
      '4', List.of("g", "h", "i"),
      '5', List.of("j", "k", "l"),
      '6', List.of("m", "n", "o"),
      '7', List.of("p", "q", "r", "s"),
      '8', List.of("t", "u", "v"),
      '9', List.of("w", "x", "y", "z")
   );

   public static void main(String[] args) {
      List<String> strings = letterCombinations("23");
      for (String string : strings) {
         System.out.println(string);
      }
   }

   private static List<String> letterCombinations(String digits) {
      if (digits == null || digits.isBlank()) {
         return Collections.emptyList();
      }
      List<String> result = new ArrayList<>();

      List<List<String>> lists = new ArrayList<>();
      for (char digit : digits.toCharArray()) {
         lists.add(mapping.get(digit));
      }

      generatePermutations(lists, result, 0, "");
      return result;
   }

   private static void generatePermutations(List<List<String>> lists, List<String> result, int depth, String current) {
      if (depth == lists.size()) {
         result.add(current);
         return;
      }

      for (int i = 0; i < lists.get(depth).size(); i++) {
         generatePermutations(lists, result, depth + 1, current + lists.get(depth).get(i));
      }
   }
}
