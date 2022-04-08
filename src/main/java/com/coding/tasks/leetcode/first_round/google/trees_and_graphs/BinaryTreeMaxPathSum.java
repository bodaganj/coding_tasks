package com.coding.tasks.leetcode.first_round.google.trees_and_graphs;

public class BinaryTreeMaxPathSum {

   private static int max;

   public static void main(String[] args) {
      TreeNode tn15 = new TreeNode(15);
      TreeNode tn7 = new TreeNode(7);
      TreeNode tn20 = new TreeNode(20, tn7, tn15);
      TreeNode tn9 = new TreeNode(9);
      TreeNode tn10 = new TreeNode(-10, tn9, tn20);

      System.out.println(maxPathSum(tn10));
   }

   private static int maxPathSum(TreeNode root) {
      max = Integer.MIN_VALUE;
      dfs(root);
      return max;
   }

   private static int dfs(TreeNode node) {
      if (node == null) {
         return 0;
      }

      int maxRight = dfs(node.right);
      int maxLeft = dfs(node.left);
      max = Math.max(max, node.val + maxRight + maxLeft);

      int currMax = Math.max(node.val, node.val + Math.max(maxLeft, maxRight));
      max = Math.max(max, currMax);

      return currMax;
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
