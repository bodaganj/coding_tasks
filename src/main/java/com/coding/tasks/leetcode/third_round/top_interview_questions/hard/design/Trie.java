package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.design;

import java.util.HashMap;
import java.util.Map;

public class Trie {

   private final TreeNode root;

   public Trie() {
      root = new TreeNode();
   }

   public static void main(String[] args) {
      Trie trie = new Trie();
      trie.insert("apple");
      System.out.println(trie.search("apple"));
      System.out.println(trie.search("app"));
      System.out.println(trie.startsWith("app"));
      trie.insert("app");
      System.out.println(trie.search("app"));
   }

   public void insert(String word) {
      TreeNode tmp = root;
      for (char c : word.toCharArray()) {
         if (tmp.children.containsKey(c)) {
            tmp = tmp.children.get(c);
         } else {
            TreeNode newNode = new TreeNode();
            tmp.children.put(c, newNode);
            tmp = newNode;
         }
      }
      tmp.isWord = true;
   }

   public boolean search(String word) {
      TreeNode tmp = get(word);
      return tmp != null && tmp.isWord;
   }

   public boolean startsWith(String prefix) {
      return get(prefix) != null;
   }

   private TreeNode get(String str) {
      TreeNode tmp = root;
      for (char c : str.toCharArray()) {
         if (tmp.children.containsKey(c)) {
            tmp = tmp.children.get(c);
         } else {
            return null;
         }
      }
      return tmp;
   }

   private class TreeNode {

      public Map<Character, TreeNode> children = new HashMap<>();
      public boolean isWord;
   }
}
