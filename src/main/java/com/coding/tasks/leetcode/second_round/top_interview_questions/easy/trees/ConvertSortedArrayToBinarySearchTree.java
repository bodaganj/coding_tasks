package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.trees;

public class ConvertSortedArrayToBinarySearchTree {

   public static void main(String[] args) {
//      TreeNode node = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
//      System.out.println(node);
//
//      TreeNode node1 = sortedArrayToBST(new int[]{0, 1, 2, 3, 4, 5});
//      System.out.println(node1);
   }

//   private static TreeNode sortedArrayToBST(int[] nums) {
//
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
