package com.coding.tasks.leetcode.second_round.google.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSquares {

   public static void main(String[] args) {
      System.out.println(wordSquares(new String[]{"abat", "baba", "atan", "atal"}));
      System.out.println(wordSquares(new String[]{"abaa", "aaab", "baaa", "aaba"}));
      System.out.println(wordSquares(new String[]{"area", "lead", "wall", "lady", "ball"}));
      System.out.println(wordSquares(new String[]{"a"}));
   }

   private static List<List<String>> wordSquares(String[] words) {
      Trie trie = createTrie(words);
      List<List<String>> ans = new ArrayList<>();
      for (String word : words) {
         List<String> current = new ArrayList<>();
         current.add(word);
         rec(trie, words, current, ans);
      }

      return ans;
   }

   private static void rec(Trie trie, String[] words, List<String> current, List<List<String>> ans) {
      if (current.size() == words[0].length()) {
         ans.add(new ArrayList<>(current));
      } else {
         StringBuilder sb = new StringBuilder();
         int size = current.size();
         for (String s : current) {
            sb.append(s.charAt(size));
         }
         String prefix = sb.toString();

         List<String> stringWithPrefix = getStringWithPrefix(prefix, trie);
         for (String withPrefix : stringWithPrefix) {
            current.add(withPrefix);
            rec(trie, words, current, ans);
            current.remove(current.size() - 1);
         }
      }
   }

   private static List<String> getStringWithPrefix(String prefix, Trie trie) {
      TreeNode tmp = trie.root;
      for (char aChar : prefix.toCharArray()) {
         if (tmp.children.containsKey(aChar)) {
            tmp = tmp.children.get(aChar);
         } else {
            return Collections.emptyList();
         }
      }

      return tmp.listWords;
   }

   private static Trie createTrie(String[] words) {
      Trie trie = new Trie();
      for (String word : words) {
         TreeNode tmp = trie.root;
         for (char aChar : word.toCharArray()) {
            if (tmp.children.containsKey(aChar)) {
               tmp = tmp.children.get(aChar);
            } else {
               TreeNode treeNode = new TreeNode(aChar);
               tmp.children.put(aChar, treeNode);
               tmp = treeNode;
            }
            tmp.listWords.add(word);
         }
      }
      return trie;
   }

   static class Trie {

      public TreeNode root;

      public Trie() {
         this.root = new TreeNode(' ');
      }
   }

   static class TreeNode {

      public Character value;
      public Map<Character, TreeNode> children = new HashMap<>();
      public List<String> listWords = new ArrayList<>();

      public TreeNode(Character value) {
         this.value = value;
      }
   }
}
