package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.dynamic_programming;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {

   public static void main(String[] args) {
      System.out.println(wordBreak("leetcode", List.of("leet", "code"))); // true
      System.out.println(wordBreak("applepenapple", List.of("apple", "pen"))); // true
      System.out.println(wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat"))); // false

//      System.out.println(wordBreak("cars", List.of("car", "ca", "rs")));
//      System.out.println(wordBreak("azaza", List.of("ff", "fv")));
//      System.out.println(wordBreak("cars", List.of("car", "ca", "s")));
//      System.out.println(wordBreak("aaaaaaa", List.of("aaaa", "aaa", "asdf", "sdfd")));
   }

   private static boolean wordBreak(String s, List<String> wordDict) {
      TreeNode root = createTrie(wordDict);
      return dfs(s, root);
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
      Trie trie = new Trie();
      TreeNode tmp;
      for (String word : wordDict) {
         tmp = trie.root;
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
      return trie.root;
   }

   static class Trie {

      public TreeNode root = new TreeNode(' ');
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
