package com.coding.tasks.leetcode.third_round.fb.others;

import java.util.*;

public class PermutationInString {

  public static void main(String[] args) {
    System.out.println(checkInclusion("ab", "eidbaooo"));
  }

  public static boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) {
      return false;
    } else {
      Map<Character, Integer> s1Map = getAnagram(s1);

      int left = 0;
      int right = 0;
      Map<Character, Integer> s2Map = new HashMap<>();
      while (right < s1.length()) {
        char c = s2.charAt(right);
        s2Map.put(c, s2Map.getOrDefault(c, 0) + 1);
        right++;
      }

      while (right < s2.length()) {
        if (s2Map.equals(s1Map)) {
          return true;
        }

        s2Map.put(s2.charAt(right), s2Map.getOrDefault(s2.charAt(right), 0) + 1);

        char c = s2.charAt(left);
        s2Map.put(c, s2Map.get(c) - 1);
        if (s2Map.get(c) == 0) {
          s2Map.remove(c);
        }

        left++;
        right++;
      }
      return s2Map.equals(s1Map);
    }
  }

  private static Map<Character, Integer> getAnagram(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    return map;
  }
}
