package com.coding.tasks.other;

public class PostOrderTraversal {

   public static void main(String[] args) {
      TreeNode tn3 = new TreeNode(3);
      TreeNode tn5 = new TreeNode(5);
      TreeNode tn4 = new TreeNode(4, tn3, tn5);
      TreeNode tn1 = new TreeNode(1);
      TreeNode tn2 = new TreeNode(2, tn1, tn4);
      postOrderTravers(tn2);
   }

   private static void postOrderTravers(TreeNode root) {
      if (root == null) {
         return;
      }

      postOrderTravers(root.left);
      postOrderTravers(root.right);
      System.out.println(root.val);
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
