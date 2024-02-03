package com.coding.tasks.leetcode.third_round.amazon.arrays.and.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class MostCommonWord {

   public static void main(String[] args) {
      System.out.println(mostCommonWord("a, a, a, a, b,b,b,c, c", new String[]{"a"}));
   }

   public static String mostCommonWord(String paragraph, String[] banned) {
      Set<String> bannedWords = new HashSet<>(Arrays.asList(banned));
      Map<String, Integer> wordsMapping = new HashMap<>();
      String mostCommonStr = "";
      int mostCommonCount = 0;

      for (String str : paragraph.split("[\s!?',;.]")) {
         if (Objects.equals(str, "")) {
            continue;
         }
         String curr = str.toLowerCase();
         if (!bannedWords.contains(curr)) {
            if (!wordsMapping.containsKey(curr)) {
               wordsMapping.put(curr, 1);
            } else {
               wordsMapping.put(curr, wordsMapping.get(curr) + 1);
            }

            int currentCount = wordsMapping.get(curr);
            if (currentCount > mostCommonCount) {
               mostCommonCount = currentCount;
               mostCommonStr = curr;
            }
         }
      }

      return mostCommonStr;
   }
}
