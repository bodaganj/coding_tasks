package com.coding.tasks.leetcode.amazon.trees_and_graphs;

public class DiameterOfBinaryTree {

   private static int maxPath;

   public static void main(String[] args) {
      TreeNode tn5 = new TreeNode(5);
      TreeNode tn4 = new TreeNode(4);
      TreeNode tn3 = new TreeNode(3);
      TreeNode tn2 = new TreeNode(2, tn4, tn5);
      TreeNode tn1 = new TreeNode(1, tn2, tn3);

      System.out.println(diameterOfBinaryTree(tn1));
   }

   private static int diameterOfBinaryTree(TreeNode root) {
      maxPath = 0;
      dfs(root);
      return maxPath;
   }

   private static int dfs(TreeNode node) {
      if (node == null) {
         return -1;
      }

      int left = 1 + dfs(node.left);
      int right = 1 + dfs(node.right);

      maxPath = Math.max(maxPath, left + right);

      return Math.max(left, right);
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
