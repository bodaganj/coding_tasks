package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.trees;

public class MaximumDepthOfBinaryTree {

   private static int max = 0;

   public static void main(String[] args) {
      TreeNode tn7 = new TreeNode(7);
      TreeNode tn15 = new TreeNode(15);
      TreeNode tn20 = new TreeNode(20, tn15, tn7);
      TreeNode tn9 = new TreeNode(9);
      TreeNode tn3 = new TreeNode(3, tn9, tn20);

      System.out.println(maxDepth(tn3));

      TreeNode tn5 = new TreeNode(5);
      TreeNode tn1 = new TreeNode(1);
      TreeNode tn6 = new TreeNode(6);
      TreeNode tn8 = new TreeNode(8);
      TreeNode tn11 = new TreeNode(1, tn5, tn1);
      TreeNode tn33 = new TreeNode(3, null, tn6);
      TreeNode tn_1 = new TreeNode(-1, null, tn8);
      TreeNode tn2 = new TreeNode(2, tn11, null);
      TreeNode tn4 = new TreeNode(4, tn33, tn_1);
      TreeNode tn0 = new TreeNode(0, tn2, tn4);

      System.out.println(maxDepth(tn0));
   }

   private static int maxDepth(TreeNode root) {
      if (root == null) {
         return 0;
      }

      max = 0;
      getMax(root, 0);
      return max;
   }

   private static void getMax(TreeNode node, int current) {
      if (node != null) {
         max = Math.max(current + 1, max);
         getMax(node.left, current + 1);
         getMax(node.right, current + 1);
      }
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
