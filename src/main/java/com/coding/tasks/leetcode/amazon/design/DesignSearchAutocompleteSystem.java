package com.coding.tasks.leetcode.amazon.design;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DesignSearchAutocompleteSystem {

   public static void main(String[] args) {
      AutocompleteSystem o = new AutocompleteSystem(new String[]{"i love you", "island", "iroman", "i love leetcode"},
                                                    new int[]{5, 3, 2, 2});
      System.out.println(o.input('i'));
      System.out.println(o.input(' '));
      System.out.println(o.input('a'));
      System.out.println(o.input('#'));
   }

   /**
    * Your AutocompleteSystem object will be instantiated and called as such:
    * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
    * List<String> param_1 = obj.input(c);
    */
   static class AutocompleteSystem {

      private final Map<String, Integer> sentenceToHotMap;
      private StringBuilder sb;

      public AutocompleteSystem(String[] sentences, int[] times) {
         sentenceToHotMap = new HashMap<>();
         for (int i = 0; i < sentences.length; i++) {
            sentenceToHotMap.put(sentences[i], times[i]);
         }
         sb = new StringBuilder();
      }

      public List<String> input(char c) {
         if (c == '#') {
            String sentence = sb.toString();
            sentenceToHotMap.put(sentence, sentenceToHotMap.getOrDefault(sentence, 0) + 1);
            sb = new StringBuilder();
            return Collections.emptyList();
         } else {
            sb.append(c);
            return sentenceToHotMap.entrySet().stream()
                                   .filter(entry -> entry.getKey().startsWith(sb.toString()))
                                   .sorted(Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed().thenComparing(Map.Entry::getKey))
                                   .limit(3)
                                   .map(Map.Entry::getKey)
                                   .collect(Collectors.toList());
         }
      }
   }
}
