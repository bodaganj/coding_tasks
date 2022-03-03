package com.coding.tasks.cracking.the.code.sorting_and_searching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

   private static List<List<String>> groupAnagrams(String[] strs) {
      Map<Map<Character, Integer>, List<String>> map = new HashMap<>();

      for (String str : strs) {
         Map<Character, Integer> strMapping = new HashMap<>();
         for (char aChar : str.toCharArray()) {
            strMapping.put(aChar, strMapping.getOrDefault(aChar, 0) + 1);
         }

         List<String> list;
         if (map.containsKey(strMapping)) {
            list = map.get(strMapping);
         } else {
            list = new ArrayList<>();
         }
         list.add(str);
         map.put(strMapping, list);
      }

      return new ArrayList<>(map.values());
   }
}
