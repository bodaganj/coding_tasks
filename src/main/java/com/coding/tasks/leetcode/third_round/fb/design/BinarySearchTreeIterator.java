package com.coding.tasks.leetcode.third_round.fb.design;

import java.util.Stack;

public class BinarySearchTreeIterator {

  class BSTIterator {

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
      stack = new Stack<>();
      TreeNode dummy = root;
      while (dummy != null) {
        stack.add(dummy);
        dummy = dummy.left;
      }
    }

    public int next() {
      TreeNode pop = stack.pop();
      if (pop.right != null) {
        TreeNode dummy = pop.right;
        while (dummy != null) {
          stack.add(dummy);
          dummy = dummy.left;
        }
      }
      return pop.val;
    }

    public boolean hasNext() {
      return !stack.isEmpty();
    }
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {this.val = val;}

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
