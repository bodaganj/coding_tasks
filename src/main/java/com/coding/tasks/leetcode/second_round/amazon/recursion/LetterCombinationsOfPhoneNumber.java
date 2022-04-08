package com.coding.tasks.leetcode.second_round.amazon.recursion;

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
//      List<String> strings = letterCombinations("23");
//      for (String string : strings) {
//         System.out.println(string);
//      }
//   }
//
//   private static List<String> letterCombinations(String digits) {
   }
}
