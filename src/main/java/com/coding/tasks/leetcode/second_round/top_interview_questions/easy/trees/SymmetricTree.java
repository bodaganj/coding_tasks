package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.trees;

public class SymmetricTree {

   public static void main(String[] args) {
//      TreeNode tn3333 = new TreeNode(3);
//      TreeNode tn2222 = new TreeNode(2);
//      TreeNode tn1111 = new TreeNode(1, tn2222, tn3333);
//
//      System.out.println(isSymmetric(tn1111));
//
//      TreeNode tn4 = new TreeNode(4);
//      TreeNode tn3 = new TreeNode(3);
//      TreeNode tn234 = new TreeNode(2, tn4, tn3);
//      TreeNode tn243 = new TreeNode(2, tn3, tn4);
//      TreeNode tn1 = new TreeNode(1, tn234, tn243);
//
//      System.out.println(isSymmetric(tn1));
//
//      TreeNode tn333 = new TreeNode(3);
//      TreeNode tn33 = new TreeNode(3);
//      TreeNode tn222 = new TreeNode(2, null, tn333);
//      TreeNode tn22 = new TreeNode(2, null, tn33);
//      TreeNode tn11 = new TreeNode(1, tn22, tn222);
//
//      System.out.println(isSymmetric(tn11));
//
//      TreeNode tn0 = new TreeNode(0);
//      TreeNode tn111 = new TreeNode(1, tn0, null);
//
//      System.out.println(isSymmetric(tn111));
//   }
//
//   private static boolean isSymmetric(TreeNode root) {
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
