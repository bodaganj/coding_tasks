package com.coding.tasks.leetcode.second_round.google.trees_and_graphs;

public class CountCompleteTreeNodes {

   public static void main(String[] args) {
      TreeNode tn6 = new TreeNode(6);
      TreeNode tn5 = new TreeNode(5);
      TreeNode tn4 = new TreeNode(4);
      TreeNode tn3 = new TreeNode(3, tn6, null);
      TreeNode tn2 = new TreeNode(2, tn4, tn5);
      TreeNode tn1 = new TreeNode(1, tn2, tn3);
      System.out.println(countNodes(tn1));

      System.out.println(countNodes(tn6));
   }

   private static int countNodes(TreeNode root) {
      int leftHeight = getMaxHeight(root, false);
      int rightHeight = getMaxHeight(root, true);
      if (leftHeight == rightHeight) {
         return (int) Math.pow(2, leftHeight) - 1;
      } else {
         int rightMiddleHeight = getMaxHeight(root.right, false);
         if (rightMiddleHeight + 1 == rightHeight) {
            int leftAmount = getNodesAmount(root.left);
            return leftAmount + 1 + (int) Math.pow(2, rightHeight - 1) - 1;
         } else {
            int rightAmount = getNodesAmount(root.right);
            return rightAmount + 1 + (int) Math.pow(2, leftHeight - 1) - 1;
         }
      }
   }

   private static int getMaxHeight(TreeNode node, boolean isRight) {
      if (node == null) {
         return 0;
      } else {
         return 1 + (isRight ? getMaxHeight(node.right, true) : getMaxHeight(node.left, false));
      }
   }

   private static int getNodesAmount(TreeNode node) {
      if (node == null) {
         return 0;
      } else {
         return 1 + getNodesAmount(node.left) + getNodesAmount(node.right);
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
