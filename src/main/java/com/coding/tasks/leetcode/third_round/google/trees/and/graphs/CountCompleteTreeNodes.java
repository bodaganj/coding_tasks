package com.coding.tasks.leetcode.third_round.google.trees.and.graphs;

public class CountCompleteTreeNodes {

   public static void main(String[] args) {

   }

//   public static int countNodes(TreeNode root) {
//      // check left height
//      // check right heigth
//      // if equal -> return 2^k - 1
//   }

   public class TreeNode {

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
