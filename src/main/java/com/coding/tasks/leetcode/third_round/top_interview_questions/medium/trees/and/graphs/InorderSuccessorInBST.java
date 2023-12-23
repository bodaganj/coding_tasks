package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.trees.and.graphs;

public class InorderSuccessorInBST {

   public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
      if (p.right != null) {
         TreeNode ans = p.right;
         while (ans.left != null) {
            ans = ans.left;
         }
         return ans;
      } else {
         TreeNode curMinMax = null;
         while (root != p) {
            if (root.val > p.val) {
               curMinMax = root;
               root = root.left;
            } else {
               root = root.right;
            }
         }
         return curMinMax;
      }
   }

   public class TreeNode {

      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int x) {
         val = x;
      }
   }
}
