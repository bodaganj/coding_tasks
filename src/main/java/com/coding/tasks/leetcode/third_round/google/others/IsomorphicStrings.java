package com.coding.tasks.leetcode.third_round.google.others;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {

   public static void main(String[] args) {
      System.out.println(isIsomorphic("abba", "assa")); // true
      System.out.println(isIsomorphic("paper", "title")); // true
      System.out.println(isIsomorphic("bbbaaaba", "aaabbbba")); // false
      System.out.println(isIsomorphic("asd", "sdd")); // false
   }

   public static boolean isIsomorphic(String s, String t) {
      if (s.length() != t.length()) {
         return false;
      } else {
         Map<Character, Character> sMapping = new HashMap<>();
         Set<Character> tSeen = new HashSet<>();
         for (int i = 0; i < s.length(); i++) {
            char currS = s.charAt(i);
            char currT = t.charAt(i);

            if ((sMapping.containsKey(currS) && !tSeen.contains(currT)) || (!sMapping.containsKey(currS) && tSeen.contains(currT))) {
               return false;
            } else {
               if (!sMapping.containsKey(currS)) {
                  sMapping.put(currS, currT);
                  tSeen.add(currT);
               } else {
                  if (sMapping.get(currS) != currT) {
                     return false;
                  }
               }
            }
         }
      }
      return true;
   }
}
