package com.coding.tasks.leetcode.top.interview.questions.medium.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {

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
      System.out.println(letterCombinations("29"));
      System.out.println(letterCombinations("356"));
   }

   private static List<String> letterCombinations(String digits) {
      if (digits == null || digits.isBlank()) {
         return Collections.emptyList();
      }

      List<String> allCombinations = new ArrayList<>();

      rec(digits, "", allCombinations);
      return allCombinations;
   }

   private static void rec(String digits, String currentString, List<String> allCombinations) {
      if (digits.isBlank()) {
         allCombinations.add(currentString);
         return;
      }

      for (String string : mapping.get(digits.charAt(0))) {
         rec(digits.substring(1), currentString + string, allCombinations);
      }
   }
}
