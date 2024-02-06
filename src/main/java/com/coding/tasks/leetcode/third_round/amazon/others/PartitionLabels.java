package com.coding.tasks.leetcode.third_round.amazon.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PartitionLabels {

   public static void main(String[] args) {

   }

   public static List<Integer> partitionLabels(String s) {
      List<Integer> ans = new ArrayList<>();
      Map<Character, Integer> charCounts = getCharCounts(s);
      int count = 0;
      Set<Character> set = new HashSet<>();
      for (int i = 0; i < s.length(); i++) {
         count++;
         char currentChar = s.charAt(i);
         set.add(currentChar);
         charCounts.put(currentChar, charCounts.get(currentChar) - 1);
         if (charCounts.get(currentChar) == 0) {
            charCounts.remove(currentChar);
            set.remove(currentChar);
         }
         if (set.isEmpty()) {
            ans.add(count);
            count = 0;
         }
      }
      return ans;
   }

   private static Map<Character, Integer> getCharCounts(String s) {
      Map<Character, Integer> map = new HashMap<>();
      for (char c : s.toCharArray()) {
         map.put(c, map.getOrDefault(c, 0) + 1);
      }
      return map;
   }
}
