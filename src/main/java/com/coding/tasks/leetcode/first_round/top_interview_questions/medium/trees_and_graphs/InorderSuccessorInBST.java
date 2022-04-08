package com.coding.tasks.leetcode.first_round.top_interview_questions.medium.trees_and_graphs;

import java.util.ArrayList;
import java.util.List;

public class InorderSuccessorInBST {

   public static void main(String[] args) {

   }

   private static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
      List<TreeNode> inOrderTraversal = new ArrayList<>();
      recursiveInOrderTraversal(root, inOrderTraversal);

      for (int i = 0; i < inOrderTraversal.size(); i++) {
         if (inOrderTraversal.get(i) == p && i != inOrderTraversal.size() - 1) {
            return inOrderTraversal.get(i + 1);
         }
      }
      return null;
   }

   private static void recursiveInOrderTraversal(TreeNode root, List<TreeNode> inOrderTraversal) {
      if (root == null) {
         return;
      }

      recursiveInOrderTraversal(root.left, inOrderTraversal);
      inOrderTraversal.add(root);
      recursiveInOrderTraversal(root.right, inOrderTraversal);
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
