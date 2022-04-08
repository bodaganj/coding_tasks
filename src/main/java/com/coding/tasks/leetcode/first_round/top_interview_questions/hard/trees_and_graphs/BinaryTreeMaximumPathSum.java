package com.coding.tasks.leetcode.first_round.top_interview_questions.hard.trees_and_graphs;

public class BinaryTreeMaximumPathSum {

   private static int max_sum = Integer.MIN_VALUE;

   public static void main(String[] args) {
      TreeNode t7 = new TreeNode(7);
      TreeNode t15 = new TreeNode(15);
      TreeNode t20 = new TreeNode(20, t15, t7);
      TreeNode t9 = new TreeNode(9);
      TreeNode t10 = new TreeNode(-10, t9, t20);

      System.out.println(maxPathSum(t10));
   }

   private static int maxPathSum(TreeNode root) {
      max_sum = Integer.MIN_VALUE;
      maxGain(root);
      return max_sum;
   }

   private static int maxGain(TreeNode node) {
      if (node == null) {
         return 0;
      }

      // max sum on the left and right sub-trees of node
      int leftGain = Math.max(maxGain(node.left), 0);
      int rightGain = Math.max(maxGain(node.right), 0);

      // the price to start a new path where `node` is a highest node
      int priceNewPath = node.val + leftGain + rightGain;

      // update max_sum if it's better to start a new path
      max_sum = Math.max(max_sum, priceNewPath);

      // for recursion :
      // return the max gain if continue the same path
      return node.val + Math.max(leftGain, rightGain);
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
