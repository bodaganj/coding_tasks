package com.coding.tasks.leetcode.first_round.amazon.trees_and_graphs;

public class BinaryTreeMaximumPathSum {

   private static int max;

   public static void main(String[] args) {
      TreeNode n3 = new TreeNode(3);
      TreeNode n2 = new TreeNode(2);
      TreeNode n1 = new TreeNode(1, n2, n3);

      System.out.println(maxPathSum(n1));
   }

   private static int maxPathSum(TreeNode root) {
      max = Integer.MIN_VALUE;
      dfs(root);
      return max;
   }

   private static int dfs(TreeNode node) {
      if (node == null) {
         return Integer.MIN_VALUE;
      }

      int leftMax = Math.max(dfs(node.left), 0);
      int rightMax = Math.max(dfs(node.right), 0);

      max = Math.max(max, node.val + leftMax + rightMax);

      return node.val + Math.max(leftMax, rightMax);
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
