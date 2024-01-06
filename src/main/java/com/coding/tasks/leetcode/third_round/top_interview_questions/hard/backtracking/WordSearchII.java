package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class WordSearchII {

   private static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
   private static Trie trie;

   public static void main(String[] args) {
      System.out.println(findWords(new char[][]{
                                      {'o', 'a', 'b', 'n'},
                                      {'o', 't', 'a', 'e'},
                                      {'a', 'h', 'k', 'r'},
                                      {'a', 'f', 'l', 'v'}
                                   },
                                   new String[]{"oa", "oaa"})); // oa, oaa

      System.out.println(findWords(new char[][]{
                                      {'a', 'b', 'c'},
                                      {'a', 'e', 'd'},
                                      {'a', 'f', 'g'}
                                   },
                                   new String[]{"abcdefg", "gfedcbaaa", "eaabcdgfa", "befa", "dgc", "ade"})); // abcdefg, gfedcbaaa, eaabcdgfa, befa

      System.out.println(findWords(new char[][]{
                                      {'b'},
                                      {'a'},
                                      {'b'},
                                      {'b'},
                                      {'a'},
                                   },
                                   new String[]{"abba", "aba", "baab", "baa"})); // abba
   }

   public static List<String> findWords(char[][] board, String[] words) {
      trie = getTrie(words);
      List<String> ans = new ArrayList<>();
      for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board[0].length; j++) {
            if (trie.root.children.isEmpty()) {
               return ans;
            }
            dfs(i, j, board, trie.root, ans, new HashSet<>());
         }
      }
      return ans;
   }

   private static void dfs(int i, int j, char[][] board, TreeNode node, List<String> ans, Set<Pair> seen) {
      TreeNode tmp = node;
      if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && tmp.children.containsKey(board[i][j]) && !seen.contains(new Pair(i,
                                                                                                                                          j))) {
         TreeNode newNode = tmp.children.get(board[i][j]);
         Set<Pair> newSet = new HashSet<>(seen);
         newSet.add(new Pair(i, j));
         if (newNode.isWord && !ans.contains(newNode.word)) {
            ans.add(newNode.word);
            removeWordFromTrie(newNode.word);
         }
         tmp = newNode;
         for (int[] ints : dir) {
            dfs(i + ints[0], j + ints[1], board, tmp, ans, newSet);
         }
      }
   }

   private static void removeWordFromTrie(String word) {
      TreeNode tmp = trie.root;
      Stack<TreeNode> stack = new Stack<>();
      char[] chars = word.toCharArray();
      for (char aChar : chars) {
         TreeNode treeNode = tmp.children.get(aChar);
         stack.add(treeNode);
         tmp = treeNode;
      }

      Character remove = null;
      while (!stack.isEmpty()) {
         TreeNode pop = stack.pop();
         if (remove != null) {
            pop.children.remove(remove);
         }
         if (pop.children.size() == 0) {
            remove = pop.val;
         } else {
            break;
         }
      }
   }

   private static Trie getTrie(String[] words) {
      Trie trie = new Trie();
      for (String word : words) {
         TreeNode tmp = trie.root;
         char[] chars = word.toCharArray();
         for (int i = 0; i < chars.length; i++) {
            char curr = chars[i];
            if (tmp.children.containsKey(curr)) {
               tmp = tmp.children.get(curr);
            } else {
               TreeNode newNode = new TreeNode(curr);
               tmp.children.put(curr, newNode);
               tmp = newNode;
            }
            if (i == chars.length - 1) {
               tmp.isWord = true;
               tmp.word = word;
            }
         }
      }
      return trie;
   }

   private static class Trie {

      public TreeNode root = new TreeNode('$');
   }

   private static class TreeNode {

      public Character val;
      public Map<Character, TreeNode> children = new HashMap<>();
      public boolean isWord;
      public String word;

      public TreeNode(Character val) {
         this.val = val;
      }
   }

   private record Pair(int x, int y) {

   }

//   public static List<String> findWords(char[][] board, String[] words) {
//      List<String> ans = new ArrayList<>();
//      Map<Character, Integer> allCharsStat = getAllCharsStat(board);
//      for (String word : words) {
//         if (wordCanBeFoundInMatrix(word, allCharsStat)) {
//            check(board, word, ans);
//         }
//      }
//
//      return ans;
//   }
//
//   private static boolean check(char[][] board, String word, List<String> ans) {
//      for (int i = 0; i < board.length; i++) {
//         for (int j = 0; j < board[0].length; j++) {
//            if (board[i][j] == word.charAt(0)) {
//               Set<Pair> set = new HashSet<>();
//               set.add(new Pair(i, j));
//               if (dfs(i, j, 1, word, set, ans, board)) {
//                  return true;
//               }
//            }
//         }
//      }
//      return false;
//   }
//
//   private static boolean dfs(int i, int j, int index, String word, Set<Pair> seen, List<String> ans, char[][] board) {
//      if (index == word.length()) {
//         ans.add(word);
//         return true;
//      } else {
//         for (int[] ints : dir) {
//            int x = i + ints[0];
//            int y = j + ints[1];
//            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && !seen.contains(new Pair(x, y)) && board[x][y] == word.charAt(
//               index)) {
//               seen.add(new Pair(x, y));
//               boolean dfs = dfs(i + ints[0], j + ints[1], index + 1, word, seen, ans, board);
//               seen.remove(new Pair(x, y));
//               if (dfs) {
//                  return true;
//               }
//            }
//         }
//         return false;
//      }
//   }
//
//   private static Map<Character, Integer> getAllCharsStat(char[][] board) {
//      Map<Character, Integer> mapping = new HashMap<>();
//      for (char[] chars : board) {
//         for (char aChar : chars) {
//            mapping.put(aChar, mapping.getOrDefault(aChar, 0) + 1);
//         }
//      }
//      return mapping;
//   }
//
//   private static boolean wordCanBeFoundInMatrix(String word, Map<Character, Integer> allCharsStat) {
//      Map<Character, Integer> wordMapping = new HashMap<>();
//      for (char c : word.toCharArray()) {
//         wordMapping.put(c, wordMapping.getOrDefault(c, 0) + 1);
//      }
//
//      for (Map.Entry<Character, Integer> entry : wordMapping.entrySet()) {
//         if (!allCharsStat.containsKey(entry.getKey()) || allCharsStat.get(entry.getKey()) < entry.getValue()) {
//            return false;
//         }
//      }
//      return true;
//   }
}
