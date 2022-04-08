package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.trees_and_graphs;

public class BinaryTreeZigzagLevelOrderTraversal {

   public static void main(String[] args) {
      TreeNode t7 = new TreeNode(7);
      TreeNode t15 = new TreeNode(15);
      TreeNode t20 = new TreeNode(20, t15, t7);
      TreeNode t9 = new TreeNode(9);
//      TreeNode t3 = new TreeNode(3, t9, t20);
//      System.out.println(zigzagLevelOrder(t3));
//   }
//
//   private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
