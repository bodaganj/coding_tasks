package com.coding.tasks.other;

public class InOrderTraversal {

   public static void main(String[] args) {
      TreeNode tn3 = new TreeNode(3);
      TreeNode tn5 = new TreeNode(5);
      TreeNode tn4 = new TreeNode(4, tn3, tn5);
      TreeNode tn1 = new TreeNode(1);
      TreeNode tn2 = new TreeNode(2, tn1, tn4);
      inOrderTravers(tn2);

      TreeNode tn111 = new TreeNode(-2147483648);
      inOrderTravers(tn111);
   }

   private static void inOrderTravers(TreeNode root) {
      if (root == null) {
         return;
      }

      inOrderTravers(root.left);
      System.out.println(root.val);
      inOrderTravers(root.right);
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
