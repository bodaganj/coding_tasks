package com.coding.tasks.leetcode.google.dynamic_programming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestPalindromicSubstring {

   private static LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();

   public static void main(String[] args) {
      System.out.println(longestPalindromicSubstring.longestPalindrome("aacabdkacaa"));
   }

   public String longestPalindrome(String s) {
      Set<String> palindromes = new HashSet<>();

      List<Character> inputChars = s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

      Map<Character, List<Integer>> charIndexesMapping = new HashMap<>();
      for (int i = 0; i < inputChars.size(); i++) {
         char aChar = inputChars.get(i);
         if (charIndexesMapping.containsKey(aChar)) {
            List<Integer> integers = charIndexesMapping.get(aChar);
            integers.add(i);
            charIndexesMapping.put(aChar, integers);
         } else {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(i);
            charIndexesMapping.put(aChar, tmp);
         }
      }

      for (Character aChar : inputChars) {
         List<Integer> indexesList = charIndexesMapping.get(aChar);
         if (indexesList.size() == 1) {
            continue;
         }

         for (int i = 0; i < indexesList.size() - 1; i++) {
            for (int j = i + 1; j < indexesList.size(); j++) {
               StringBuilder sb = new StringBuilder();
               for (Character character : inputChars.subList(indexesList.get(i), indexesList.get(j) + 1)) {
                  sb.append(character);
               }

               if (isPalindrome(sb)) {
                  palindromes.add(sb.toString());
               }
            }
         }
      }

      if (palindromes.isEmpty()) {
         return String.valueOf(s.charAt(0));
      } else {
         return palindromes.stream().max(Comparator.comparingInt(String::length)).get();
      }
   }

   private boolean isPalindrome(StringBuilder sb) {
      return sb.toString().equals(sb.reverse().toString());
   }
}
