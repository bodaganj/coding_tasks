package com.coding.tasks.leetcode.google.trees_and_graphs;

public class BinaryTreeMaxPathSum {

   private static int max_sum = Integer.MIN_VALUE;

   public static void main(String[] args) {
      TreeNode tn15 = new TreeNode(15);
      TreeNode tn7 = new TreeNode(7);
      TreeNode tn20 = new TreeNode(20, tn15, tn7);
      TreeNode tn9 = new TreeNode(9, null, null);
      TreeNode root = new TreeNode(10, tn9, tn20);

      TreeNode root0 = new TreeNode(0);

      System.out.println(maxPathSum(root));
      System.out.println(maxPathSum(root0));
   }

   private static int maxPathSum(TreeNode root) {
      max_sum = Integer.MIN_VALUE;
      max_gain(root);
      return max_sum;
   }

   private static int max_gain(TreeNode node) {
      if (node == null) {
         return 0;
      }

      // max sum on the left and right sub-trees of node
      int left_gain = Math.max(max_gain(node.left), 0);
      int right_gain = Math.max(max_gain(node.right), 0);

      // the price to start a new path where `node` is a highest node
      int price_newpath = node.val + left_gain + right_gain;

      // update max_sum if it's better to start a new path
      max_sum = Math.max(max_sum, price_newpath);

      // for recursion :
      // return the max gain if continue the same path
      return node.val + Math.max(left_gain, right_gain);
   }

   static public class TreeNode {

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
