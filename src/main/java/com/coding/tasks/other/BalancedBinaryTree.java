package com.coding.tasks.other;

public class BalancedBinaryTree {

   public static void main(String[] args) {
//      TreeNode tn6 = new TreeNode(6);
      TreeNode tn3 = new TreeNode(3, null, null);
      TreeNode tn5 = new TreeNode(5);
      TreeNode tn4 = new TreeNode(4, tn3, tn5);
      TreeNode tn1 = new TreeNode(1);
      TreeNode tn2 = new TreeNode(2, tn1, tn4);
      System.out.println(isBalanced(tn2));

//      TreeNode tn1 = new TreeNode(1);
//      TreeNode tn2 = new TreeNode(2, tn1, null);
//      System.out.println(isBalanced(tn2));
   }

   private static boolean isBalanced(TreeNode root) {
      if (root == null) {
         return true;
      }

      return Math.abs(getMaxHeight(root.left) - getMaxHeight(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
   }

   private static int getMaxHeight(TreeNode node) {
      if (node == null) {
         return 0;
      }

      return 1 + Math.max(getMaxHeight(node.left), getMaxHeight(node.right));
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
