package com.coding.tasks.leetcode.third_round.fb.design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AddAndSearchWordDataStructureDesign {

  class WordDictionary {

    private Set<String> set;
    private TreeNode root;

    public WordDictionary() {
      set = new HashSet<>();
      root = new TreeNode();
    }

    public void addWord(String word) {
      set.add(word);
      TreeNode tmp = root;
      for (char curr : word.toCharArray()) {
        if (!tmp.children.containsKey(curr)) {
          TreeNode newNode = new TreeNode();
          tmp.children.put(curr, newNode);
        }
        tmp = tmp.children.get(curr);
      }
      tmp.word = word;
    }

    public boolean search(String word) {
      if (!word.contains(".")) {
        return set.contains(word);
      } else {
        return rec(0, word, root);
      }
    }

    private boolean rec(int index, String s, TreeNode node) {
      if (index >= s.length()) {
        return false;
      }
      char curr = s.charAt(index);
      if (curr == '.') {
        for (Map.Entry<Character, TreeNode> entry : node.children.entrySet()) {
          if (index == s.length() - 1 && entry.getValue().word != null) {
            return true;
          } else {
            if (rec(index + 1, s, entry.getValue())) {
              return true;
            }
          }
        }
        return false;
      } else {
        if (node.children.containsKey(curr)) {
          if (index == s.length() - 1) {
            return node.children.get(curr).word != null;
          } else {
            return rec(index + 1, s, node.children.get(curr));
          }
        } else {
          return false;
        }
      }
    }
  }

  class TreeNode {

    private String word;
    private Map<Character, TreeNode> children = new HashMap<>();
  }
}
