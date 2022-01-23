package com.coding.tasks.leetcode.google;

public class InvertBinaryTree {

   /**
    * BFS (via queues) might be used also!!
    * @param args
    */
   public static void main(String[] args) {
      TreeNode treeNodeOne = new TreeNode(1);
      TreeNode treeNodeThree = new TreeNode(3);
      TreeNode treeNodeTwo = new TreeNode(2, treeNodeOne, treeNodeThree);

      TreeNode treeNodeSix = new TreeNode(6);
      TreeNode treeNodeNine = new TreeNode(9);
      TreeNode treeNodeSeven = new TreeNode(7, treeNodeSix, treeNodeNine);

      TreeNode root = new TreeNode(4, treeNodeTwo, treeNodeSeven);

      TreeNode revertedTree = invertTree(root);
      System.out.println(revertedTree);
   }

   private static TreeNode invertTree(TreeNode root) {
      if (root != null) {
         TreeNode tmp = root.left;
         root.left = root.right;
         root.right = tmp;

         invertTree(root.left);
         invertTree(root.right);
      }

      return root;
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
