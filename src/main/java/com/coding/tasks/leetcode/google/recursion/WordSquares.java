package com.coding.tasks.leetcode.google.recursion;

import java.util.ArrayList;
import java.util.List;

public class WordSquares {

   public static void main(String[] args) {
      System.out.println(wordSquares(new String[]{"ball", "area", "lead", "lady"}));
   }

   private static List<List<String>> wordSquares(String[] words) {
      List<List<String>> ans = new ArrayList<>();
      for (int i = 0; i < words.length; i++) {
         rec(i, new ArrayList<>(), words, ans);
      }

      return ans;
   }

   private static void rec(int i, List<String> currentList, String[] words, List<List<String>> ans) {
      if (currentList.size() == words[0].length()) {
         ans.add(currentList);
         return;
      }

      for (String word : words) {
         if (currentList.isEmpty()) {
            List<String> tmp = new ArrayList<>(currentList);
            tmp.add(word);
            rec(i + 1, tmp, words, ans);
         } else {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
               if (j >= currentList.size() || i >= word.length() || currentList.get(j).charAt(i) != word.charAt(j)) {
                  flag = false;
                  break;
               } else {
                  flag = true;
               }
            }
            if (flag) {
               List<String> tmp = new ArrayList<>(currentList);
               tmp.add(word);
               rec(i + 1, tmp, words, ans);
            }
         }
      }
   }
}
