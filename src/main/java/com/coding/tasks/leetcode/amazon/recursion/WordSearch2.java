package com.coding.tasks.leetcode.amazon.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordSearch2 {

   private static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

   public static void main(String[] args) {
//      System.out.println(findWords(new char[][]{
//                                      {'o', 'a', 'a', 'n'},
//                                      {'e', 't', 'a', 'e'},
//                                      {'i', 'h', 'k', 'r'},
//                                      {'i', 'f', 'l', 'v'}
//                                   },
//                                   new String[]{"oath", "pea", "eat", "rain"}));

      System.out.println(findWords(new char[][]{
                                      {'o', 'a', 'a', 'n'},
                                      {'e', 't', 'a', 'e'},
                                      {'i', 'h', 'k', 'r'},
                                      {'i', 'f', 'l', 'v'}
                                   },
                                   new String[]{"oath", "pea", "eat", "rain", "hklf", "hf"}));

//      System.out.println(findWords(new char[][]{
//                                      {'o', 'a', 'b', 'n'},
//                                      {'o', 't', 'a', 'e'},
//                                      {'a', 'h', 'k', 'r'},
//                                      {'a', 'f', 'l', 'v'}
//                                   },
//                                   new String[]{"oa", "oaa"}));
//
//      System.out.println(findWords(new char[][]{
//                                      {'a'}
//                                   },
//                                   new String[]{"a"}));
//
//      System.out.println(findWords(new char[][]{
//                                      {'a', 'a'}
//                                   },
//                                   new String[]{"aaa"}));
   }

   private static List<String> findWords(char[][] board, String[] words) {
      Trie trie = getTrie(words);

      // Go through the board and check if root.children.containsKey(board[i][j])
      // if word - add to list
      // if not - get all its children and go through all i/j +- 1...
      List<String> ans = new ArrayList<>();
      Set<String> visitedWords = new HashSet<>();

      for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board[0].length; j++) {
            if (trie.root.children.containsKey(board[i][j])) {
               int[][] visitedCoord = new int[board.length][board[0].length];
               visitedCoord[i][j] = 1;
               dfs(board, i, j, trie.root.children.get(board[i][j]), ans, visitedCoord, visitedWords);
            }
         }
      }

      return ans;
   }

   private static Trie getTrie(String[] words) {
      Trie trie = new Trie();

      // Create Trie
      TreeNode node;
      for (String word : words) {
         node = trie.root;
         for (int i = 0; i < word.length(); i++) {
            char aChar = word.charAt(i);
            TreeNode tmp = new TreeNode(aChar, false);

            if (i == word.length() - 1) {
               tmp.isWord = true;
               tmp.word = word;
            }

            if (!node.children.containsKey(aChar)) {
               node.children.put(aChar, tmp);
               node = tmp;
            } else {
               if (i == word.length() - 1) {
                  node.children.get(aChar).isWord = true;
                  node.children.get(aChar).word = word;
               }
               node = node.children.get(aChar);
            }
         }
      }

      return trie;
   }

   private static void dfs(char[][] board, int x, int y, TreeNode node, List<String> ans, int[][] visitedCoord, Set<String> visitedWords) {
      if (node.isWord && !visitedWords.contains(node.word)) {
         ans.add(node.word);
         visitedWords.add(node.word);
      }

      for (int[] ints : dir) {
         int i = x + ints[0];
         int j = y + ints[1];

         if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && visitedCoord[i][j] != 1 && node.children.containsKey(board[i][j])) {
            visitedCoord[i][j] = 1;
            dfs(board, i, j, node.children.get(board[i][j]), ans, visitedCoord, visitedWords);
         }
      }
   }

   static class Trie {

      public TreeNode root;

      public Trie() {
         this.root = new TreeNode();
      }
   }

   static class TreeNode {

      public Character val;
      public boolean isWord;
      public String word;
      public Map<Character, TreeNode> children = new HashMap<>();

      public TreeNode(Character val, boolean isWord) {
         this.val = val;
         this.isWord = isWord;
      }

      public TreeNode() {

      }
   }
}
