package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.backtracking;

import java.util.ArrayList;
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

   public static List<String> letterCombinations(String digits) {
      List<String> ans = new ArrayList<>();
      if (digits.length() == 0) {
         return ans;
      }
      rec(digits, 0, "", ans);
      return ans;
   }

   private static void rec(String digits, int index, String curr, List<String> ans) {
      if (index == digits.length()) {
         ans.add(curr);
         return;
      }

      for (String s : mapping.get(digits.charAt(index))) {
         rec(digits, index + 1, curr + s, ans);
      }
   }
}
