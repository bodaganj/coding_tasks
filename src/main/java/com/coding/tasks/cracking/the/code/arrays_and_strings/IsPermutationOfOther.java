package com.coding.tasks.cracking.the.code.arrays_and_strings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IsPermutationOfOther {

   public static void main(String[] args) {
      System.out.println(isPermutation("abc", "bca"));
      System.out.println(isPermutation("abc", "bcad"));
      System.out.println(isPermutation("abcd", "bca"));
   }

   /**
    * Given two string, write a method to decide if one is a permutation of the other
    * O(A + B)
    */
   private static boolean isPermutation(String input, String main) {
      Map<Character, Integer> mainStringMapper = new HashMap<>();
      List<Character> mainCharactersList = main.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
      for (Character character : mainCharactersList) {
         mainStringMapper.put(character, mainStringMapper.getOrDefault(character, 0) + 1);
      }

      Map<Character, Integer> inputStringMapper = new HashMap<>();
      List<Character> inputCharactersList = input.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
      for (Character character : inputCharactersList) {
         inputStringMapper.put(character, inputStringMapper.getOrDefault(character, 0) + 1);
      }

      return inputStringMapper.equals(mainStringMapper);
   }
}
