package com.coding.tasks.leetcode.third_round.apple.trees.and.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SameTree {

  public static boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == q) {
      return true;
    }
    if (p == null || q == null) {
      return false;
    }
    if (p.val == q.val) {
      return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    } else {
      return false;
    }
  }

//  public static boolean isSameTree(TreeNode p, TreeNode q) {
//    return getNodeRepresentation(p).equals(getNodeRepresentation(q));
//  }
//
//  private static List<String> getNodeRepresentation(TreeNode node) {
//    List<String> ans = new ArrayList<>();
//    Queue<TreeNode> queue = new LinkedList<>();
//    queue.add(node);
//    while (!queue.isEmpty()) {
//      int size = queue.size();
//      while (size > 0) {
//        TreeNode poll = queue.poll();
//        if (poll == null) {
//          ans.add("#");
//        } else {
//          ans.add(poll.val + "");
//          queue.add(poll.left);
//          queue.add(poll.right);
//        }
//        size--;
//      }
//    }
//    return ans;
//  }

  private static class TreeNode {
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
