package com.coding.tasks.leetcode.second_round.amazon.trees_and_graphs;

public class DiameterOfBinaryTree {

   public static void main(String[] args) {
//      TreeNode tn5 = new TreeNode(5);
//      TreeNode tn4 = new TreeNode(4);
//      TreeNode tn3 = new TreeNode(3);
//      TreeNode tn2 = new TreeNode(2, tn4, tn5);
//      TreeNode tn1 = new TreeNode(1, tn2, tn3);
//
//      System.out.println(diameterOfBinaryTree(tn1));
//
//      TreeNode t9 = new TreeNode(9);
//      TreeNode t8 = new TreeNode(8);
//      TreeNode t7 = new TreeNode(7, t9, null);
//      TreeNode t6 = new TreeNode(6, t8, null);
//      TreeNode t5 = new TreeNode(5, t7, null);
//      TreeNode t4 = new TreeNode(4, t6, null);
//      TreeNode t3 = new TreeNode(3);
//      TreeNode t2 = new TreeNode(2, t4, t5);
//      TreeNode t1 = new TreeNode(1, t2, t3);
//
//      System.out.println(diameterOfBinaryTree(t1));
//   }
//
//   private static int diameterOfBinaryTree(TreeNode root) {
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
