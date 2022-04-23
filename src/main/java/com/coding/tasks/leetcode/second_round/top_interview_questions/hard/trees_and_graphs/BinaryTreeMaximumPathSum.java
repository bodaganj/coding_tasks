package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.trees_and_graphs;

public class BinaryTreeMaximumPathSum {

   private static int maxSum = Integer.MIN_VALUE;

   public static void main(String[] args) {
      TreeNode t7 = new TreeNode(7);
      TreeNode t15 = new TreeNode(15);
      TreeNode t20 = new TreeNode(20, t15, t7);
      TreeNode t9 = new TreeNode(9);
      TreeNode t10 = new TreeNode(-10, t9, t20);

      System.out.println(maxPathSum(t10));
   }

   private static int maxPathSum(TreeNode root) {
      maxSum = Integer.MIN_VALUE;
      getMax(root);
      return maxSum;
   }

   private static int getMax(TreeNode node) {
      if (node == null) {
         return 0;
      } else {
         int left = Math.max(getMax(node.left), 0);
         int right = Math.max(getMax(node.right), 0);

         int currentMax = node.val + left + right;

         maxSum = Math.max(maxSum, currentMax);
         return Math.max(left, right) + node.val;
      }
   }

   static class TreeNode {

      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int x) {
         val = x;
      }

      TreeNode(int x, TreeNode left, TreeNode right) {
         val = x;
         this.left = left;
         this.right = right;
      }
   }
}
