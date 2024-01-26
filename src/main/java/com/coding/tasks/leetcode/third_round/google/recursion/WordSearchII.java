package com.coding.tasks.leetcode.third_round.google.recursion;

import java.util.*;

public class WordSearchII {

  private static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public static void main(String[] args) {
    System.out.println(findWords(new char[][]{
            {'o', 'a', 'a', 'n'},
            {'e', 't', 'a', 'e'},
            {'i', 'h', 'k', 'r'},
            {'i', 'f', 'l', 'v'}
        },
        new String[]{"oath", "pea", "eat", "rain"}));
  }

  public static List<String> findWords(char[][] board, String[] words) {
    TreeNode treeNode = buildTrie(words);
    List<String> ans = new ArrayList<>();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (treeNode.children.isEmpty()) {
          return ans;
        } else {
          TreeNode tmp = treeNode;
          rec(i, j, board, tmp, new HashSet<>(), ans);
        }
      }
    }
    return ans;
  }

  private static void rec(int i, int j, char[][] board, TreeNode treeNode, Set<List<Integer>> set, List<String> ans) {
    if (treeNode.children.containsKey(board[i][j])) {
      Set<List<Integer>> tmp = new HashSet<>(set);
      tmp.add(List.of(i, j));
      TreeNode node = treeNode.children.get(board[i][j]);
      if (node.word != null) {
        ans.add(node.word);
      }
      for (int[] dir : dirs) {
        int x = i + dir[0];
        int y = j + dir[1];
        if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && !set.contains(List.of(x, y))) {
          rec(x, y, board, node, tmp, ans);
        }
      }

    }
  }

  private static TreeNode buildTrie(String[] words) {
    TreeNode root = new TreeNode();
    for (String word : words) {
      TreeNode node = root;
      for (char c : word.toCharArray()) {
        if (!node.children.containsKey(c)) {
          node.children.put(c, new TreeNode());
        }
        node = node.children.get(c);
      }
      node.word = word;
    }
    return root;
  }

  private static class TreeNode {
    Map<Character, TreeNode> children;
    String word;

    TreeNode() {
      children = new HashMap<>();
    }
  }
}
