package com.coding.tasks.leetcode.third_round.top_interview_questions.google.arrays.and.strings;

import java.util.ArrayList;
import java.util.List;

public class ExpressiveWords {

   public static void main(String[] args) {
      System.out.println(expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"}));
      System.out.println(expressiveWords("zzzzzyyyyy", new String[]{"zzyy", "zy", "zyy"}));
   }

   public static int expressiveWords(String s, String[] words) {
      int counter = 0;
      List<Pair> mappingS = getMapping(s);
      for (String word : words) {
         List<Pair> wordMapping = getMapping(word);
         if (isStretchy(wordMapping, mappingS)) {
            counter++;
         }
      }
      return counter;
   }

   private static List<Pair> getMapping(String word) {
      List<Pair> list = new ArrayList<>();
      char curr = word.charAt(0);
      int count = 1;
      int i = 1;
      while (i < word.length()) {
         if (word.charAt(i) == curr) {
            count++;
         } else {
            list.add(new Pair(curr, count));
            curr = word.charAt(i);
            count = 1;
         }
         i++;
      }
      list.add(new Pair(curr, count));
      return list;
   }

   private static boolean isStretchy(List<Pair> wordMapping, List<Pair> mappingS) {
      if (wordMapping.size() != mappingS.size()) {
         return false;
      }

      int i = 0;
      while (i < wordMapping.size()) {
         Pair wordPair = wordMapping.get(i);
         Pair sPair = mappingS.get(i);
         if (wordPair.c != sPair.c) {
            return false;
         }
         if (wordPair.count > sPair.count || (wordPair.count != sPair.count && sPair.count < 3)) {
            return false;
         }
         i++;
      }
      return true;
   }

   private record Pair(Character c, int count) {

   }
}
