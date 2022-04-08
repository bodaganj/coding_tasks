package com.coding.tasks.leetcode.second_round.google.trees_and_graphs;

public class CountCompleteTreeNodes {

   public static void main(String[] args) {
//      TreeNode tn6 = new TreeNode(6);
//      TreeNode tn5 = new TreeNode(5);
//      TreeNode tn4 = new TreeNode(4);
//      TreeNode tn3 = new TreeNode(3, tn6, null);
//      TreeNode tn2 = new TreeNode(2, tn4, tn5);
//      TreeNode tn1 = new TreeNode(1, tn2, tn3);
//      System.out.println(countNodes(tn1));
//
//      System.out.println(countNodes(tn6));
//   }
//
//   private static int countNodes(TreeNode root) {
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
