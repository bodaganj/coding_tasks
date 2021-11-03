package com.coding.tasks.leetcode.google.trees_and_graphs;

public class DiameterOfBinaryTree {

   private int diameter;

   public static void main(String[] args) {
      DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();

      TreeNode tn5 = new TreeNode(5);
      TreeNode tn4 = new TreeNode(4);
      TreeNode tn3 = new TreeNode(3);
      TreeNode tn2 = new TreeNode(2, tn4, tn5);
      TreeNode tn1 = new TreeNode(1, tn2, tn3);

      System.out.println(diameterOfBinaryTree.diameterOfBinaryTree(tn1));
   }

   public int diameterOfBinaryTree(TreeNode root) {
      diameter = 0;
      longestPath(root);
      return diameter;
   }

   private int longestPath(TreeNode node) {
      if (node == null) {
         return 0;
      }

      int leftPath = longestPath(node.left);
      int rightPath = longestPath(node.right);
      diameter = Math.max(diameter, leftPath + rightPath);
      return Math.max(leftPath, rightPath) + 1;
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
