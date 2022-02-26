package com.coding.tasks.other;

import java.util.HashMap;
import java.util.Map;

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
public class Trie {

   private TrieNode root;

   public Trie() {
      root = new TrieNode();
      root.val = ' ';
   }

   public void insert(String word) {
      TrieNode trieNode = root;

      for (char aChar : word.toCharArray()) {
         if (!trieNode.children.containsKey(aChar)) {
            trieNode.children.put(aChar, new TrieNode(aChar));
         }
         trieNode = trieNode.children.get(aChar);
      }

      trieNode.isWord = true;
   }

   public boolean search(String word) {
      TrieNode trieNode = root;

      for (char aChar : word.toCharArray()) {
         if (!trieNode.children.containsKey(aChar)) {
            return false;
         }
         trieNode = trieNode.children.get(aChar);
      }

      return trieNode.isWord;
   }

   public boolean startsWith(String prefix) {
      TrieNode trieNode = root;
      for (char aChar : prefix.toCharArray()) {
         if (!trieNode.children.containsKey(aChar)) {
            return false;
         }
         trieNode = trieNode.children.get(aChar);
      }
      return true;
   }

   static class TrieNode {

      public char val;
      public boolean isWord;
      public Map<Character, TrieNode> children = new HashMap<>();

      public TrieNode() {
      }

      TrieNode(char c) {
         TrieNode node = new TrieNode();
         node.val = c;
      }
   }
}

