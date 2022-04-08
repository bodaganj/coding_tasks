package com.coding.tasks.leetcode.second_round.amazon.trees_and_graphs;

public class SymmetricTree {

   public static void main(String[] args) {

   }

//   private static boolean isSymmetricIteratively(TreeNode root) {
//   }

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
