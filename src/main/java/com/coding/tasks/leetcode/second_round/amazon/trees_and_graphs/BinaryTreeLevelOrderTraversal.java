package com.coding.tasks.leetcode.second_round.amazon.trees_and_graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

   private static List<List<Integer>> levelOrder(TreeNode root) {
      if (root == null) {
         return Collections.emptyList();
      }

      List<List<Integer>> ans = new ArrayList<>();
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);

      while (!queue.isEmpty()) {
         List<Integer> values = new ArrayList<>();
         int size = queue.size();
         while (size > 0) {
            TreeNode poll = queue.poll();
            values.add(poll.val);

            if (poll.left != null) {
               queue.offer(poll.left);
            }
            if (poll.right != null) {
               queue.offer(poll.right);
            }

            size--;
         }

         ans.add(values);
      }

      return ans;
   }

   static class TreeNode {

      int val;
      TreeNode left;
      TreeNode right;

      TreeNode() {
      }

      TreeNode(int val) {
         this.val = val;
      }

      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
      }
   }
}
