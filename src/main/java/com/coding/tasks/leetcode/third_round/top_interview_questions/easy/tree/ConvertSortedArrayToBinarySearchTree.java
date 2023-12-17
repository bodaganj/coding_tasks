package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.tree;

import java.util.Arrays;

public class ConvertSortedArrayToBinarySearchTree {

   public static void main(String[] args) {
      TreeNode node = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
      System.out.println(node);
   }

   public static TreeNode sortedArrayToBST(int[] nums) {
      return rec(nums);
   }

   private static TreeNode rec(int[] nums) {
      if (nums.length == 0) {
         return null;
      }
      if (nums.length == 1) {
         return new TreeNode(nums[0]);
      }

      int mid = nums.length / 2;
      TreeNode node = new TreeNode(nums[mid]);
      node.left = rec(Arrays.copyOfRange(nums, 0, mid));
      node.right = rec(Arrays.copyOfRange(nums, mid + 1, nums.length));
      return node;
   }

   public static class TreeNode {

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
