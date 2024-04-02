package com.coding.tasks.leetcode.third_round.fb.others;

import java.util.HashMap;
import java.util.Map;

public class VerifyingAnAlienDictionary {

  public boolean isAlienSorted(String[] words, String order) {
    Map<Character, Integer> dictionary = new HashMap<>();
    for (int i = 0; i < order.length(); i++) {
      if (dictionary.containsKey(order.charAt(i))) {
        return false;
      } else {
        dictionary.put(order.charAt(i), i);
      }
    }

    for (int i = 0; i < words.length - 1; i++) {
      if (!isCorrect(words[i], words[i + 1], dictionary)) {
        return false;
      }
    }
    return true;
  }

  private static boolean isCorrect(String s1, String s2, Map<Character, Integer> dictionary) {
    int index = 0;
    while (index < s1.length() && index < s2.length()) {
      if (s1.charAt(index) != s2.charAt(index)) {
        return dictionary.get(s1.charAt(index)) < dictionary.get(s2.charAt(index));
      }
      index++;
    }
    return index == s1.length();
  }
}
