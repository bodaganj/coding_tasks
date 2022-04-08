package com.coding.tasks.leetcode.first_round.google.trees_and_graphs;

import java.util.LinkedList;
import java.util.Queue;

public class CountCompleteTreeNodes {

   public static void main(String[] args) {
      TreeNode tn6 = new TreeNode(6);
      TreeNode tn5 = new TreeNode(5);
      TreeNode tn4 = new TreeNode(4);
      TreeNode tn3 = new TreeNode(3, tn6, null);
      TreeNode tn2 = new TreeNode(2, tn4, tn5);
      TreeNode tn1 = new TreeNode(1, tn2, tn3);
      System.out.println(countNodes(tn1));

      System.out.println(countNodes(tn6));
   }

   private static int countNodes(TreeNode root) {
      if (root == null) {
         return 0;
      }

      int levels = getMaxLeftPath(root.left, 1); // O(d)
      int rightHalfLevel = getMaxLeftPath(root.right, 1); // O(d)

      if (levels == rightHalfLevel) {
         return finishOnTheRight(root.right, levels);
      } else {
         return finishOnTheLeft(root.left, levels);
      }
   }

   private static int getMaxLeftPath(TreeNode node, int level) {
      if (node == null) {
         return level;
      }
      return getMaxLeftPath(node.left, level + 1);
   }

   private static int finishOnTheLeft(TreeNode node, int levels) {
      if (node == null) {
         return (int) Math.pow(2, levels - 2); // root + all nodes on the left + all on the right
      } else {
         int amountOfNodesLeft = getNodesAmount(node);
         return (int) Math.pow(2, levels - 2) + amountOfNodesLeft; // root + all nodes on the left + all on the right
      }
   }

   private static int finishOnTheRight(TreeNode node, int levels) {
      if (node == null) {
         return (int) Math.pow(2, levels - 1); // root + all nodes on the left + all on the right
      } else {
         int amountOfNodesRight = getNodesAmount(node);
         return (int) Math.pow(2, levels - 1) + amountOfNodesRight; // root + all nodes on the left + all on the right
      }
   }

   private static int getNodesAmount(TreeNode node) {
      int count = 0;
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(node);

      while (!queue.isEmpty()) {
         count++;
         TreeNode poll = queue.poll();
         if (poll.left != null) {
            queue.offer(poll.left);
         }
         if (poll.right != null) {
            queue.offer(poll.right);
         }
      }
      return count;
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
