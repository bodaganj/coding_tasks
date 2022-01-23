package com.coding.tasks.other;

public class PreOrderTraversal {

   public static void main(String[] args) {
      InOrderTraversal.TreeNode tn3 = new InOrderTraversal.TreeNode(3);
      InOrderTraversal.TreeNode tn5 = new InOrderTraversal.TreeNode(5);
      InOrderTraversal.TreeNode tn4 = new InOrderTraversal.TreeNode(4, tn3, tn5);
      InOrderTraversal.TreeNode tn1 = new InOrderTraversal.TreeNode(1);
      InOrderTraversal.TreeNode tn2 = new InOrderTraversal.TreeNode(2, tn1, tn4);
      preOrderTravers(tn2);
   }

   private static void preOrderTravers(InOrderTraversal.TreeNode root) {
      if (root == null) {
         return;
      }

      System.out.println(root.val);
      preOrderTravers(root.left);
      preOrderTravers(root.right);
   }

   static class TreeNode {

      int val;
      InOrderTraversal.TreeNode left;
      InOrderTraversal.TreeNode right;

      TreeNode() {
      }

      TreeNode(int val) {
         this.val = val;
      }

      TreeNode(int val, InOrderTraversal.TreeNode left, InOrderTraversal.TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
      }
   }
}
