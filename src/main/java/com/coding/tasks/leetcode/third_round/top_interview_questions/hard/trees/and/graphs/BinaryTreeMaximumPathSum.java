package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.trees.and.graphs;

public class BinaryTreeMaximumPathSum {

   private static int max = Integer.MIN_VALUE;

   public static void main(String[] args) {
      TreeNode t7 = new TreeNode(7);
      TreeNode t15 = new TreeNode(15);
      TreeNode t20 = new TreeNode(20, t15, t7);
      TreeNode t9 = new TreeNode(9);
      TreeNode t10 = new TreeNode(-10, t9, t20);

      System.out.println(maxPathSum(t10));
   }

   public static int maxPathSum(TreeNode root) {
      rec(root);
      return max;
   }

   private static int rec(TreeNode node) {
      if (node == null) {
         return 0;
      }

      int left = rec(node.left);
      int right = rec(node.right);

      int branchMax = Math.max(left, right);
      int currentMax = Math.max(node.val, node.val + branchMax);
      max = Math.max(max, Math.max(left + right + node.val, currentMax));
      return currentMax;
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
