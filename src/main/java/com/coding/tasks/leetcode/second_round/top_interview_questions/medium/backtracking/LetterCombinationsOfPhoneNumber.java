package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.backtracking;

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
      if (digits.isEmpty()) {
         return Collections.emptyList();
      } else {
         List<String> ans = new ArrayList<>();
         rec(digits, "", ans);
         return ans;
      }
   }

   private static void rec(String digit, String current, List<String> ans) {
      if (digit.isEmpty()) {
         ans.add(current);
         return;
      }

      for (String s : mapping.get(digit.charAt(0))) {
         rec(digit.substring(1), current + s, ans);
      }
   }
}
