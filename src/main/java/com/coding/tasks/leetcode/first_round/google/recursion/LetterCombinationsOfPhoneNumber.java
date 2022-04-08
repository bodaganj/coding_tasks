package com.coding.tasks.leetcode.first_round.google.recursion;

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
      System.out.println(letterCombinations("234"));
   }

   private static List<String> letterCombinations(String digits) {
      if (digits == null || digits.isBlank()) {
         return Collections.emptyList();
      }

      List<String> ans = new ArrayList<>();
      dfs(0, digits, "", ans);

      return ans;
   }

   private static void dfs(int index, String digits, String current, List<String> ans) {
      if (current.length() == digits.length()) {
         ans.add(current);
         return;
      }

      for (String letter : mapping.get(digits.charAt(index))) {
         dfs(index + 1, digits, current + letter, ans);
      }
   }
}
