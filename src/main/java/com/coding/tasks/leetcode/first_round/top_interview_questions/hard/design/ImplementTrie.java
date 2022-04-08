package com.coding.tasks.leetcode.first_round.top_interview_questions.hard.design;

import java.util.HashMap;
import java.util.Map;

public class ImplementTrie {

   public static void main(String[] args) {
      Trie trie = new Trie();
      trie.insert("apple");
      System.out.println(trie.search("apple")); // true
      System.out.println(trie.search("app")); // false
      System.out.println(trie.startsWith("app")); // true
      trie.insert("app");
      System.out.println(trie.search("app")); // false
   }

   /**
    * Your Trie object will be instantiated and called as such:
    * Trie obj = new Trie();
    * obj.insert(word);
    * boolean param_2 = obj.search(word);
    * boolean param_3 = obj.startsWith(prefix);
    */
   static class Trie {

      private TreeNode root;

      public Trie() {
         root = new TreeNode(' ');
      }

      public void insert(String word) {
         TreeNode tmp = root;
         char[] chars = word.toCharArray();
         for (char aChar : chars) {
            if (!tmp.children.containsKey(aChar)) {
               TreeNode tn = new TreeNode(aChar);
               tmp.children.put(aChar, tn);
            }
            tmp = tmp.children.get(aChar);
         }
         tmp.isWord = true;
      }

      public boolean search(String word) {
         TreeNode tmp = root;
         char[] chars = word.toCharArray();
         for (char aChar : chars) {
            if (tmp.children.containsKey(aChar)) {
               tmp = tmp.children.get(aChar);
            } else {
               return false;
            }
         }
         return tmp.isWord;
      }

      public boolean startsWith(String prefix) {
         TreeNode tmp = root;
         char[] chars = prefix.toCharArray();
         for (char aChar : chars) {
            if (tmp.children.containsKey(aChar)) {
               tmp = tmp.children.get(aChar);
            } else {
               return false;
            }
         }
         return true;
      }

      class TreeNode {

         private boolean isWord;
         private Character val;
         private Map<Character, TreeNode> children;

         private TreeNode(Character val) {
            this.val = val;
            this.isWord = false;
            this.children = new HashMap<>();
         }
      }
   }
}
