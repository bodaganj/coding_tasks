package com.coding.tasks.leetcode.third_round.fb.others;

import java.util.*;

public class FindAllAnagramsInString {

  public static void main(String[] args) {

  }

  public static List<Integer> findAnagrams(String s, String p) {
    if (p.length() > s.length()) {
      return Collections.emptyList();
    } else {
      List<Integer> ans = new ArrayList<>();
      Map<Character, Integer> anagramP = getAnagram(p);

      int left = 0;
      int right = 0;
      Map<Character, Integer> anagramS = new HashMap<>();
      while (right < p.length()) {
        char c = s.charAt(right);
        anagramS.put(c, anagramS.getOrDefault(c, 0) + 1);
        right++;
      }

      while (right < s.length()) {
        if (anagramS.equals(anagramP)) {
          ans.add(left);
        }

        anagramS.put(s.charAt(right), anagramS.getOrDefault(s.charAt(right), 0) + 1);

        char c = s.charAt(left);
        anagramS.put(c, anagramS.get(c) - 1);
        if (anagramS.get(c) == 0) {
          anagramS.remove(c);
        }

        left++;
        right++;
      }
      if (anagramS.equals(anagramP)) {
        ans.add(left);
      }
      return ans;
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
