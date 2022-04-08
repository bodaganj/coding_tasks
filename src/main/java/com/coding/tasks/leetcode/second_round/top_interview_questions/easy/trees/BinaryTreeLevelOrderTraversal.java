package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.trees;

public class BinaryTreeLevelOrderTraversal {

   public static void main(String[] args) {
//      TreeNode tn3 = new TreeNode(3);
//      TreeNode tn5 = new TreeNode(5);
//      TreeNode tn4 = new TreeNode(4, tn3, tn5);
//      TreeNode tn1 = new TreeNode(1);
//      TreeNode tn2 = new TreeNode(2, tn1, tn4);
//
//      List<List<Integer>> lists = levelOrder(tn2);
//
//      System.out.println(lists);
//   }
//
//   private static List<List<Integer>> levelOrder(TreeNode root) {
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
