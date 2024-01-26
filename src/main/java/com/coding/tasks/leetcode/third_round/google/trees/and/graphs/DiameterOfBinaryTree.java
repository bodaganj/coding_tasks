package com.coding.tasks.leetcode.third_round.google.trees.and.graphs;

public class DiameterOfBinaryTree {

   private static int max = 0;

   public static void main(String[] args) {
      TreeNode tn5 = new TreeNode(5);
      TreeNode tn4 = new TreeNode(4);
      TreeNode tn3 = new TreeNode(3);
      TreeNode tn2 = new TreeNode(2, tn4, tn5);
      TreeNode tn1 = new TreeNode(1, tn2, tn3);

      System.out.println(diameterOfBinaryTree(tn1));
      System.out.println("==========");
//      for (TreeNode maxPathNode : maxPathNodes) {
//         System.out.println(maxPathNode.val);
//      }
   }

   public static int diameterOfBinaryTree(TreeNode root) {
      max = 0;
      rec(root);
      return max;
   }

   private static int rec(TreeNode node) {
      if (node == null) {
         return -1;
      }

      int left = 1 + rec(node.left);
      int right = 1 + rec(node.right);
      max = Math.max(max, left + right);
      return Math.max(left, right);
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
