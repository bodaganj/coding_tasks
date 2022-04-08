package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.trees_and_graphs;

public class LowestCommonAncestorOfBinaryTree {

   public static void main(String[] args) {
      TreeNode t7 = new TreeNode(7);
      TreeNode t4 = new TreeNode(4);
      TreeNode t2 = new TreeNode(2, t7, t4);
      TreeNode t6 = new TreeNode(6);
      TreeNode t5 = new TreeNode(5, t6, t2);
      TreeNode t0 = new TreeNode(0);
      TreeNode t8 = new TreeNode(8);
      TreeNode t1 = new TreeNode(1, t0, t8);
      TreeNode t3 = new TreeNode(3, t5, t1);

//      System.out.println(lowestCommonAncestor(t3, t5, t1).val);
//      System.out.println(lowestCommonAncestor(t3, t5, t4).val);
//      System.out.println(lowestCommonAncestor(t3, t6, t4).val);
//   }
//
//   private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
   }

   static class TreeNode {

      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int x) {
         val = x;
      }

      TreeNode(int x, TreeNode left, TreeNode right) {
         val = x;
         this.left = left;
         this.right = right;
      }
   }
}
