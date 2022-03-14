package com.coding.tasks.leetcode.amazon.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PartitionLabels {

   public static void main(String[] args) {
      System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
      System.out.println(partitionLabels("eccbbbbdec"));
   }

   private static List<Integer> partitionLabels(String s) {
      Map<Character, Integer> map = new HashMap<>();
      List<Integer> ans = new ArrayList<>();
      Set<Character> visited = new HashSet<>();

      char[] chars = s.toCharArray();

      // Create dictionary
      for (char aChar : chars) {
         map.put(aChar, map.getOrDefault(aChar, 0) + 1);
      }

      StringBuilder sb = new StringBuilder();
      for (char aChar : chars) {
         visited.add(aChar);
         sb.append(aChar);

         map.put(aChar, map.get(aChar) - 1);
         if (map.get(aChar) == 0) {
            map.remove(aChar);
            visited.remove(aChar);
         }

         if (visited.isEmpty()) {
            ans.add(sb.length());
            sb = new StringBuilder();
         }
      }

      return ans;
   }
}
