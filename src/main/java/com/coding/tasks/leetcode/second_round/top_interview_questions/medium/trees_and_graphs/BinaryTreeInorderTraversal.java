package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.trees_and_graphs;

public class BinaryTreeInorderTraversal {

   public static void main(String[] args) {
      TreeNode t3 = new TreeNode(3);
      TreeNode t2 = new TreeNode(2, t3, null);
      TreeNode t1 = new TreeNode(1, null, t2);
//      System.out.println(inorderTraversalRec(t1));
//      System.out.println(inorderTraversalIter(t1));
//   }
//
//   private static List<Integer> inorderTraversalRec(TreeNode root) {
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
