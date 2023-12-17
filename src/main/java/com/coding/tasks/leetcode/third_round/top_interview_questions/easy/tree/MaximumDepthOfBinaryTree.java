package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {

   public static void main(String[] args) {

   }

//   public static int maxDepth(TreeNode root) {
//      if (root == null) {
//         return 0;
//      }
//      return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
//   }

   public static int maxDepth(TreeNode root) {
      if (root == null) {
         return 0;
      }

      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      int level = 0;
      while (!queue.isEmpty()) {
         level++;
         int size = queue.size();
         for (int i = 0; i < size; i++) {
            TreeNode curr = queue.poll();
            if (curr.left != null) {
               queue.add(curr.left);
            }
            if (curr.right != null) {
               queue.add(curr.right);
            }
         }
      }

      return level;
   }

   public static class TreeNode {

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
