package com.coding.tasks.leetcode.amazon.trees_and_graphs;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

   public static void main(String[] args) {

   }

   /**
    * Iteratively
    */
   private static boolean isSymmetricIteratively(TreeNode root) {
      if (root == null) {
         return true;
      }

      Queue<TreeNode> leftQueue = new LinkedList<>();
      leftQueue.offer(root.left);
      Queue<TreeNode> rightQueue = new LinkedList<>();
      rightQueue.offer(root.right);

      while (!leftQueue.isEmpty() || !rightQueue.isEmpty()) {
         TreeNode leftPoll = leftQueue.poll();
         TreeNode rightPoll = rightQueue.poll();

         if (leftPoll != rightPoll) {
            if (leftPoll == null || rightPoll == null || leftPoll.val != rightPoll.val) {
               return false;
            } else {
               leftQueue.offer(leftPoll.left);
               leftQueue.offer(leftPoll.right);
               rightQueue.offer(rightPoll.right);
               rightQueue.offer(rightPoll.left);
            }
         }
      }

      return true;
   }

   /**
    * Recursively
    */
   private static boolean isSymmetric(TreeNode root) {
      if (root == null) {
         return true;
      }

      return dfs(root.left, root.right);
   }

   private static boolean dfs(TreeNode node1, TreeNode node2) {
      if (node1 == node2) {
         return true;
      }
      if (node1 == null || node2 == null || node1.val != node2.val) {
         return false;
      } else {
         return dfs(node1.left, node2.right) && dfs(node1.right, node2.left);
      }
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
