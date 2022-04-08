package com.coding.tasks.leetcode.second_round.amazon.trees_and_graphs;

public class LowestCommonAncestorOfBinaryTree {

   public static void main(String[] args) {
//      TreeNode tn4 = new TreeNode(4);
//      TreeNode tn7 = new TreeNode(7);
//      TreeNode tn8 = new TreeNode(8);
//      TreeNode tn0 = new TreeNode(0);
//      TreeNode tn2 = new TreeNode(2, tn7, tn4);
//      TreeNode tn6 = new TreeNode(6);
//      TreeNode tn1 = new TreeNode(1, tn0, tn8);
//      TreeNode tn5 = new TreeNode(5, tn6, tn2);
//      TreeNode tn3 = new TreeNode(3, tn5, tn1);
//
//      System.out.println(lowestCommonAncestor(tn3, tn5, tn4).val);
//   }
//
//   private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
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
