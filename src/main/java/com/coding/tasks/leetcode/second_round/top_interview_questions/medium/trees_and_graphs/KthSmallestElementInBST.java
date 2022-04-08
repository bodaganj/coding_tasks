package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.trees_and_graphs;

public class KthSmallestElementInBST {

   public static void main(String[] args) {
      TreeNode t1 = new TreeNode(1);
      TreeNode t4 = new TreeNode(4);
      TreeNode t2 = new TreeNode(2, t1, null);
      TreeNode t6 = new TreeNode(6);
      TreeNode t3 = new TreeNode(3, t2, t4);
      TreeNode t5 = new TreeNode(5, t3, t6);
//      System.out.println(kthSmallest(t5, 3));
//
////      TreeNode t4 = new TreeNode(4);
////      TreeNode t2 = new TreeNode(2);
////      TreeNode t1 = new TreeNode(1, null, t2);
////      TreeNode t3 = new TreeNode(3, t1, t4);
////      System.out.println(kthSmallest(t3, 1));
//   }
//
//   private static int kthSmallest(TreeNode root, int k) {
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
