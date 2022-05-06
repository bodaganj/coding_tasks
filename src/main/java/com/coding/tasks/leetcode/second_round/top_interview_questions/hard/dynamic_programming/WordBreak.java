package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.dynamic_programming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak {

   public static void main(String[] args) {
      System.out.println(wordBreak("leetcode", List.of("leet", "code"))); // true
      System.out.println(wordBreak("applepenapple", List.of("apple", "pen"))); // true
      System.out.println(wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat"))); // false
   }

   private static boolean wordBreak(String s, List<String> wordDict) {
      if (!areDistinctOk(s, wordDict)) {
         return false;
      }

      TreeNode root = createTrie(wordDict);
      return dfs(s, root);
   }

   private static boolean areDistinctOk(String s, List<String> wordDict) {
      Set<Character> distinctS = new HashSet<>();
      for (char c : s.toCharArray()) {
         distinctS.add(c);
      }

      Set<Character> distinctW = new HashSet<>();
      for (String word : wordDict) {
         for (char c : word.toCharArray()) {
            distinctW.add(c);
         }
      }

      for (Character distinct : distinctS) {
         if (!distinctW.contains(distinct)) {
            return false;
         }
      }
      return true;
   }

   private static boolean dfs(String s, TreeNode node) {
      if (s.isEmpty()) {
         return true;
      } else {
         TreeNode tmp = node;
         for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (!tmp.children.containsKey(curr)) {
               break;
            } else {
               tmp = tmp.children.get(curr);
               if (tmp.word != null) {
                  boolean flag = dfs(s.substring(i + 1), node);
                  if (flag) {
                     return true;
                  }
               }
            }
         }
         return false;
      }
   }

   private static TreeNode createTrie(List<String> wordDict) {
      TreeNode root = new TreeNode(' ');
      TreeNode tmp;
      for (String word : wordDict) {
         tmp = root;
         for (char aChar : word.toCharArray()) {
            if (tmp.children.containsKey(aChar)) {
               tmp = tmp.children.get(aChar);
            } else {
               TreeNode newNode = new TreeNode(aChar);
               tmp.children.put(aChar, newNode);
               tmp = newNode;
            }
         }
         tmp.word = word;
      }
      return root;
   }

   static class TreeNode {

      public Character val;
      public String word = null;
      public Map<Character, TreeNode> children = new HashMap<>();

      public TreeNode(Character val) {
         this.val = val;
      }
   }
}
