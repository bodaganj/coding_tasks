package com.coding.tasks.leetcode.second_round.amazon.others;

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
      Map<Character, Integer> charsCount = new HashMap<>();
      for (char aChar : s.toCharArray()) {
         charsCount.put(aChar, charsCount.getOrDefault(aChar, 0) + 1);
      }

      List<Integer> ans = new ArrayList<>();
      int i = 0;
      int sum = 0;
      Set<Character> visited = new HashSet<>();
      while (i < s.length()) {
         char currentChar = s.charAt(i);
         visited.add(currentChar);

         int newCounter = charsCount.get(currentChar) - 1;
         if (newCounter == 0) {
            charsCount.remove(currentChar);

            if (checkIfAllVisitedCountZero(visited, charsCount)) {
               int lengthOfPartition = i + 1 - sum;
               ans.add(lengthOfPartition);
               sum += lengthOfPartition;

               visited = new HashSet<>();
            }
         } else {
            charsCount.put(currentChar, newCounter);
         }

         i++;
      }

      return ans;
   }

   private static boolean checkIfAllVisitedCountZero(Set<Character> visited, Map<Character, Integer> charsCount) {
      for (Character character : visited) {
         if (charsCount.containsKey(character)) {
            return false;
         }
      }
      return true;
   }
}
