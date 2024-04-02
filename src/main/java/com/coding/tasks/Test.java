package com.coding.tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {

   public static void main(String[] args) {
      System.out.println(findWords(new char[][]{
                                      {'o', 'a', 'a', 'n'},
                                      {'e', 't', 'a', 'e'},
                                      {'i', 'h', 'k', 'r'},
                                      {'i', 'f', 'l', 'v'}
                                   },
                                   new String[]{"oath", "pea", "eat", "rain"}));
   }

   private static int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

   public static List<String> findWords(char[][] board, String[] words) {
      Set<String> ans = new HashSet<>();
      TreeNode trie = getTrie(words);
      for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board[i].length; j++) {
            dfs(i, j, new HashSet<>(), board, trie, ans);
         }
      }
      return new ArrayList<>(ans);
   }

   private static void dfs(int i, int j, Set<List<Integer>> seen, char[][] board, TreeNode trie, Set<String> ans) {
      if (trie.word != null) {
         ans.add(trie.word);
      }

      if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && !seen.contains(List.of(i,
                                                                                                j)) && trie.children.containsKey(board[i][j])) {
         seen.add(List.of(i, j));
         for (int[] ints : direction) {
            int newI = i + ints[0];
            int newJ = j + ints[1];
            TreeNode nextNode = trie.children.get(board[i][j]);
            dfs(newI, newJ, seen, board, nextNode, ans);
//            if (nextNode.children.isEmpty()) {
//               trie.children.remove(board[i][j]);
//            }
         }
         seen.remove(List.of(i, j));
      }
   }

   private static TreeNode getTrie(String[] words) {
      TreeNode root = new TreeNode();
      TreeNode tmp = root;
      for (String word : words) {
         for (char c : word.toCharArray()) {
            if (tmp.children.containsKey(c)) {
               tmp = tmp.children.get(c);
            } else {
               TreeNode newNode = new TreeNode();
               tmp.children.put(c, newNode);
               tmp = newNode;
            }
         }
         tmp.word = word;
         tmp = root;
      }
      return root;
   }

   private static class TreeNode {

      public Map<Character, TreeNode> children = new HashMap<>();
      public String word = null;
   }
}
