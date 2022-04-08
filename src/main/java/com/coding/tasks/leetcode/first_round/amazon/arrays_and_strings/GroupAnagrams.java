package com.coding.tasks.leetcode.first_round.amazon.arrays_and_strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

   public static void main(String[] args) {
      System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
      System.out.println(groupAnagrams(new String[]{"a"}));
      System.out.println(groupAnagrams(new String[]{""}));
   }

   private static List<List<String>> groupAnagrams(String[] strs) {
      Map<Map<Character, Integer>, List<String>> mapping = new HashMap<>();

      for (String str : strs) {
         char[] chars = str.toCharArray();
         Map<Character, Integer> currentMapping = new HashMap<>();
         for (char aChar : chars) {
            currentMapping.put(aChar, currentMapping.getOrDefault(aChar, 0) + 1);
         }

         if (!mapping.containsKey(currentMapping)) {
            mapping.put(currentMapping, new ArrayList<>());
         }
         mapping.get(currentMapping).add(str);
      }

      return new ArrayList<>(mapping.values());
   }
}
