package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

   public static void main(String[] args) {

   }

   public static boolean isSymmetric(TreeNode root) {
      if (root == null) {
         return true;
      }

      Queue<TreeNode> leftQueue = new LinkedList<>();
      leftQueue.add(root.left);
      Queue<TreeNode> rightQueue = new LinkedList<>();
      rightQueue.add(root.right);

      while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
         TreeNode left = leftQueue.poll();
         TreeNode right = rightQueue.poll();
         if (left == null && right == null) {
            continue;
         } else if (left == null || right == null) {
            return false;
         }
         if (left.val != right.val) {
            return false;
         }
         leftQueue.add(left.left);
         leftQueue.add(left.right);
         rightQueue.add(right.right);
         rightQueue.add(right.left);
      }

      return leftQueue.isEmpty() && rightQueue.isEmpty();
   }

   public static boolean isSymmetricWithRec(TreeNode root) {
      if (root == null) {
         return true;
      }
      return rec(root.left, root.right);
   }

   private static boolean rec(TreeNode left, TreeNode right) {
      if (left == null && right == null) {
         return true;
      } else if (left == null || right == null) {
         return false;
      }

      return left.val == right.val && rec(left.left, right.right) && rec(left.right, right.left);
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
