package com.coding.tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {

   private static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

   public static void main(String[] args) {
      System.out.println(findWords(new char[][]{
                                      {'o', 'a', 'a', 'n'},
                                      {'e', 't', 'a', 'e'},
                                      {'i', 'h', 'k', 'r'},
                                      {'i', 'f', 'l', 'v'}
                                   },
                                   new String[]{"oath", "pea", "eat", "rain"}));

      System.out.println(findWords(new char[][]{
                                      {'o', 'a', 'a', 'n'},
                                      {'e', 't', 'a', 'e'},
                                      {'i', 'h', 'k', 'r'},
                                      {'i', 'f', 'l', 'v'}
                                   },
                                   new String[]{"oath", "pea", "eat", "rain", "hklf", "hf"}));

      System.out.println(findWords(new char[][]{
                                      {'o', 'a', 'b', 'n'},
                                      {'o', 't', 'a', 'e'},
                                      {'a', 'h', 'k', 'r'},
                                      {'a', 'f', 'l', 'v'}
                                   },
                                   new String[]{"oa", "oaa"}));

      System.out.println(findWords(new char[][]{
                                      {'a'}
                                   },
                                   new String[]{"a"}));

      System.out.println(findWords(new char[][]{
                                      {'a', 'a'}
                                   },
                                   new String[]{"aaa"}));
   }

   private static List<String> findWords(char[][] board, String[] words) {
      TreeNode root = constructTrie(words);
      Set<String> ans = new HashSet<>();

      for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board[0].length; j++) {
            dfs(i, j, root, ans, board, new HashSet<>());
         }
      }

      return new ArrayList<>(ans);
   }

   private static void dfs(int i, int j, TreeNode root, Set<String> ans, char[][] board, Set<List<Integer>> visited) {
      TreeNode tmp = root;
      if (tmp.children.containsKey(board[i][j])) {
         tmp = tmp.children.get(board[i][j]);
         if (tmp.word != null) {
            ans.add(tmp.word);
         }

         visited.add(List.of(i, j));
         for (int[] ints : dir) {
            int x = i + ints[0];
            int y = j + ints[1];

            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && !visited.contains(List.of(x, y))) {
               dfs(x, y, tmp, ans, board, visited);
            }
         }
         visited.remove(List.of(i, j));
      }
   }

   private static TreeNode constructTrie(String[] words) {
      TreeNode root = new TreeNode();

      for (String word : words) {
         TreeNode tmp = root;
         for (int i = 0; i < word.length(); i++) {
            char aChar = word.charAt(i);

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

      return root;
   }

   private static class TreeNode {

      public Map<Character, TreeNode> children = new HashMap<>();
      public String word;
   }
}
