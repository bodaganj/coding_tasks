package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.trees;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {

   public static void main(String[] args) {
      TreeNode tn6 = new TreeNode(8);
      TreeNode tn3 = new TreeNode(6);
      TreeNode tn4 = new TreeNode(7, tn3, tn6);
      TreeNode tn1 = new TreeNode(1);
      TreeNode tn2 = new TreeNode(5, tn1, tn4);

      System.out.println(isValidBST(tn2));

      TreeNode tn111 = new TreeNode(-2147483648);

      System.out.println(isValidBST(tn111));
   }

   private static boolean isValidBST(TreeNode root) {
      if (root == null) {
         return true;
      }

      List<Integer> listOfNodes = new ArrayList<>();
      inOrderTraversal(root, listOfNodes);
      for (int i = 1; i < listOfNodes.size(); i++) {
         if (listOfNodes.get(i) <= listOfNodes.get(i - 1)) {
            return false;
         }
      }

      return true;
   }

   private static void inOrderTraversal(TreeNode node, List<Integer> list) {
      if (node != null) {
         inOrderTraversal(node.left, list);
         list.add(node.val);
         inOrderTraversal(node.right, list);
      }
   }

//   private static boolean isValidBST(TreeNode root) {
//      if (root == null) {
//         return true;
//      }
//
//      if (root.val > getMax(root.left) && root.val < getMin(root.right)) {
//         return isValidBST(root.left) && isValidBST(root.right);
//      } else {
//         return false;
//      }
//   }
//
//   private static long getMin(TreeNode node) {
//      if (node == null) {
//         return Long.MAX_VALUE;
//      }
//
//      long left = getMin(node.left);
//      long right = getMin(node.right);
//      return Math.min(node.val, Math.min(left, right));
//   }

   private static long getMax(TreeNode node) {
      if (node == null) {
         return Long.MIN_VALUE;
      }

      long left = getMax(node.left);
      long right = getMax(node.right);
      return Math.max(node.val, Math.max(left, right));
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
