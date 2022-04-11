package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.array_and_strings;

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
         Map<Character, Integer> map = new HashMap<>();
         for (char aChar : str.toCharArray()) {
            map.put(aChar, map.getOrDefault(aChar, 0) + 1);
         }

         if (mapping.containsKey(map)) {
            mapping.get(map).add(str);
         } else {
            List<String> tmp = new ArrayList<>();
            tmp.add(str);
            mapping.put(map, tmp);
         }
      }

      return new ArrayList<>(mapping.values());
   }
}
