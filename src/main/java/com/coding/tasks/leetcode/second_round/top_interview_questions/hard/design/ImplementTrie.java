package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.design;

import java.util.HashMap;
import java.util.Map;

public class ImplementTrie {

   public static void main(String[] args) {

   }

   static class Trie {

      private TreeNode root;

      public Trie() {
         root = new TreeNode();
      }

      public void insert(String word) {
         TreeNode tmp = root;
         for (char aChar : word.toCharArray()) {
            if (tmp.children.containsKey(aChar)) {
               tmp = tmp.children.get(aChar);
            } else {
               TreeNode node = new TreeNode();
               tmp.children.put(aChar, node);
               tmp = node;
            }
         }
         tmp.isWord = true;
      }

      public boolean search(String word) {
         TreeNode node = getNode(word);
         return node != null && node.isWord;
      }

      public boolean startsWith(String prefix) {
         return getNode(prefix) != null;
      }

      private TreeNode getNode(String str) {
         TreeNode tmp = root;
         for (char aChar : str.toCharArray()) {
            if (tmp.children.containsKey(aChar)) {
               tmp = tmp.children.get(aChar);
            } else {
               return null;
            }
         }
         return tmp;
      }

      static class TreeNode {

         public boolean isWord = false;
         public Map<Character, TreeNode> children = new HashMap<>();

         public TreeNode() {
         }
      }
   }
}
