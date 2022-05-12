package com.coding.tasks.leetcode.second_round.google.other;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {

   public static void main(String[] args) {
      System.out.println(isIsomorphic("egg", "add"));
      System.out.println(isIsomorphic("foo", "bar"));
      System.out.println(isIsomorphic("paper", "title"));
   }

   private static boolean isIsomorphic(String s, String t) {
      Map<Character, Character> mapping = new HashMap<>();
      for (int i = 0; i < s.length(); i++) {
         char sChar = s.charAt(i);
         char tChar = t.charAt(i);

         if (mapping.containsKey(sChar)) {
            if (mapping.get(sChar) != tChar) {
               return false;
            }
         } else {
            Set<Character> set = new HashSet<>(mapping.values());
            if (!set.contains(tChar)) {
               mapping.put(sChar, tChar);
            } else {
               return false;
            }
         }
      }

      return true;
   }
}
