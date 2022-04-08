package com.coding.tasks.leetcode.second_round.amazon.trees_and_graphs;

public class BinaryTreeMaximumPathSum {

   private static int max;

   public static void main(String[] args) {
//      TreeNode n3 = new TreeNode(3);
//      TreeNode n2 = new TreeNode(2);
//      TreeNode n1 = new TreeNode(1, n2, n3);
//
//      System.out.println(maxPathSum(n1));
//   }
//
//   private static int maxPathSum(TreeNode root) {
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
