package com.coding.tasks.leetcode.third_round.google.recursion;

import java.util.*;

public class WordSquares {

  public static void main(String[] args) {
    System.out.println(wordSquares(new String[]{"area", "lead", "wall", "lady", "ball"}));
  }

  public static List<List<String>> wordSquares(String[] words) {
    TreeNode trie = buildTrie(words);
    List<List<String>> result = new ArrayList<>();
    backtrack(new ArrayList<>(), words, trie, result);
    return result;
  }

  private static void backtrack(List<String> tmp, String[] words, TreeNode trie, List<List<String>> result) {
    if (tmp.size() == words[0].length()) {
      result.add(new ArrayList<>(tmp));
    } else {
      StringBuilder prefix = new StringBuilder();
      int index = 0;
      while (index < tmp.size()) {
        prefix.append(tmp.get(index).charAt(tmp.size()));
        index++;
      }

      List<String> candidates = getCandidates(prefix, trie, words);
      for (String candidate : candidates) {
        tmp.add(candidate);
        backtrack(tmp, words, trie, result);
        tmp.remove(tmp.size() - 1);
      }

    }
  }

  private static List<String> getCandidates(StringBuilder prefix, TreeNode trie, String[] words) {
    if (prefix.isEmpty()) {
      return Arrays.stream(words).toList();
    } else {
      TreeNode tmp = trie;
      int index = 0;
      char[] charArray = prefix.toString().toCharArray();
      while (index < charArray.length) {
        if (tmp.children.containsKey(charArray[index])) {
          tmp = tmp.children.get(charArray[index]);
        } else {
          break;
        }
        index++;
      }
      if (index == prefix.length()) {
        return tmp.words;
      } else {
        return Collections.emptyList();
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
        node.words.add(word);
      }
    }
    return root;
  }

  private static class TreeNode {
    Map<Character, TreeNode> children;
    List<String> words;

    TreeNode() {
      children = new HashMap<>();
      words = new ArrayList<>();
    }
  }
}
