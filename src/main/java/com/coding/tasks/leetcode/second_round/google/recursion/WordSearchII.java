package com.coding.tasks.leetcode.second_round.google.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordSearchII {

   private static Trie trie;
   private static char[][] matrix;
   private static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

   public static void main(String[] args) {
      System.out.println(findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}},
                                   new String[]{"oath", "pea", "eat", "rain"}));

      System.out.println(findWords(new char[][]{{'a'}},
                                   new String[]{"a"}));
   }

   private static List<String> findWords(char[][] board, String[] words) {
      trie = createTrie(words);
      matrix = board;

      List<String> ans = new ArrayList<>();
      for (int i = 0; i < matrix.length; i++) {
         for (int j = 0; j < matrix[0].length; j++) {
            List<Integer> currentCoordinates = List.of(i, j);
            Set<List<Integer>> visited = new HashSet<>();
            visited.add(currentCoordinates);
            dfs(currentCoordinates, visited, trie.root, ans);
            visited.remove(currentCoordinates);
         }
      }

      return ans;
   }

   private static void dfs(List<Integer> coordinates, Set<List<Integer>> visited, TreeNode node, List<String> ans) {
      if (node.children.containsKey(matrix[coordinates.get(0)][coordinates.get(1)])) {
         TreeNode newNode = node.children.get(matrix[coordinates.get(0)][coordinates.get(1)]);

         if (newNode.word != null) {
            ans.add(newNode.word);
            newNode.word = null;
         }

         if (!newNode.children.isEmpty()) {
            for (int[] dir : dirs) {
               int i = coordinates.get(0) + dir[0];
               int j = coordinates.get(1) + dir[1];
               List<Integer> newCoordinates = List.of(i, j);

               if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length && !visited.contains(newCoordinates) &&
                  newNode.children.containsKey(matrix[newCoordinates.get(0)][newCoordinates.get(1)])) {
                  visited.add(newCoordinates);
                  dfs(newCoordinates, visited, newNode, ans);
                  visited.remove(newCoordinates);
               }
            }
         }
      }
   }

   private static Trie createTrie(String[] words) {
      Trie trie = new Trie();
      for (String word : words) {
         TreeNode tmp = trie.root;
         for (char aChar : word.toCharArray()) {
            if (tmp.children.containsKey(aChar)) {
               tmp = tmp.children.get(aChar);
            } else {
               TreeNode newNode = new TreeNode();
               tmp.children.put(aChar, newNode);
               tmp = newNode;
            }
         }
         tmp.word = word;
      }

      return trie;
   }

   static class Trie {

      public TreeNode root;

      public Trie() {
         this.root = new TreeNode();
      }
   }

   static class TreeNode {

      public Map<Character, TreeNode> children = new HashMap<>();
      public String word = null;

      public TreeNode() {
      }
   }
}
