package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.trees_and_graphs;

public class BinaryTreeMaximumPathSum {

   private static int max_sum = Integer.MIN_VALUE;

   public static void main(String[] args) {
//      TreeNode t7 = new TreeNode(7);
//      TreeNode t15 = new TreeNode(15);
//      TreeNode t20 = new TreeNode(20, t15, t7);
//      TreeNode t9 = new TreeNode(9);
//      TreeNode t10 = new TreeNode(-10, t9, t20);
//
//      System.out.println(maxPathSum(t10));
//   }
//
//   private static int maxPathSum(TreeNode root) {
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
