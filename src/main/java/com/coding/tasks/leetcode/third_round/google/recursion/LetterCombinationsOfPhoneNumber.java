package com.coding.tasks.leetcode.third_round.google.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {

  public static void main(String[] args) {
    System.out.println(letterCombinations("25"));
  }

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
    if (digits.isEmpty()) {
      return ans;
    }
    backtrack(digits, "", ans);
    return ans;
  }

  private static void backtrack(String digits, String currStr, List<String> ans) {
    if (digits.isEmpty()) {
      ans.add(currStr);
    } else {
      for (String letter : mapping.get(digits.charAt(0))) {
        backtrack(digits.substring(1), currStr + letter, ans);
      }
    }
  }
}
