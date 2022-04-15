package com.coding.tasks.leetcode.second_round.google.arrays_and_strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpressiveWords {

   public static void main(String[] args) {
      System.out.println(expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"}));
      System.out.println(expressiveWords("zzzzzyyyyy", new String[]{"zzyy", "zy", "zyy"}));
      System.out.println(expressiveWords("abcd", new String[]{"abc"}));
      System.out.println(expressiveWords("heeellooo", new String[]{"heeelloooworld"}));
      System.out.println(expressiveWords("aaa", new String[]{"aaaa"}));
   }

   private static int expressiveWords(String s, String[] words) {
      List<Map<Character, Integer>> initList = getDictionary(s);

      int count = 0;
      for (String word : words) {
         count += isStretchy(initList, word);
      }
      return count;
   }

   private static int isStretchy(List<Map<Character, Integer>> initList, String word) {
      List<Map<Character, Integer>> currList = getDictionary(word);

      if (currList.size() != initList.size()) {
         return 0;
      }

      for (int i = 0; i < initList.size(); i++) {
         Map<Character, Integer> ini = initList.get(i);
         Map<Character, Integer> cur = currList.get(i);

         if (!ini.keySet().equals(cur.keySet())) {
            return 0;
         }
         if (ini.values().stream().findFirst().get() < cur.values().stream().findFirst().get()) {
            return 0;
         } else {
            if (ini.values().stream().findFirst().get() > cur.values().stream().findFirst().get() && ini.values().stream().findFirst().get() < 3) {
               return 0;
            }
         }
      }

      return 1;
   }

   private static List<Map<Character, Integer>> getDictionary(String word) {
      List<Map<Character, Integer>> currList = new ArrayList<>();
      Character prev = null;
      Map<Character, Integer> tmp = new HashMap<>();
      for (char aChar : word.toCharArray()) {
         if (prev != null && prev.equals(aChar)) {
            tmp.put(aChar, tmp.get(aChar) + 1);
         } else {
            if (!tmp.isEmpty()) {
               currList.add(tmp);
            }
            prev = aChar;
            tmp = new HashMap<>();
            tmp.put(aChar, 1);
         }
      }
      if (!tmp.isEmpty()) {
         currList.add(tmp);
      }
      return currList;
   }
}
