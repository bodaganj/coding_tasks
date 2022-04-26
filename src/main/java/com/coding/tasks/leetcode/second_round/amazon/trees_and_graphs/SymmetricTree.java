package com.coding.tasks.leetcode.second_round.amazon.trees_and_graphs;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

   public static void main(String[] args) {

   }

   private static boolean isSymmetricRec(TreeNode root) {
      return rec(root.left, root.right);
   }

   private static boolean rec(TreeNode left, TreeNode right) {
      if (left == right) {
         return true;
      } else if (left == null || right == null) {
         return false;
      } else if (left.val != right.val) {
         return false;
      }

      return rec(left.left, right.right) && rec(left.right, right.left);
   }

   private static boolean isSymmetricIteratively(TreeNode root) {
      Queue<TreeNode> queueLeft = new LinkedList<>();
      Queue<TreeNode> queueRight = new LinkedList<>();
      if (root.left == root.right) {
         return true;
      } else if (root.left == null || root.right == null) {
         return false;
      }
      queueLeft.offer(root.left);
      queueRight.offer(root.right);

      while (!queueLeft.isEmpty() && !queueRight.isEmpty()) {
         TreeNode pollLeft = queueLeft.poll();
         TreeNode pollRight = queueRight.poll();

         if (pollLeft.val != pollRight.val) {
            return false;
         }

         if (pollLeft.left != pollRight.right) {
            if (pollLeft.left == null || pollRight.right == null) {
               return false;
            } else {
               queueLeft.offer(pollLeft.left);
               queueRight.offer(pollRight.right);
            }
         }

         if (pollLeft.right != pollRight.left) {
            if (pollLeft.right == null || pollRight.left == null) {
               return false;
            } else {
               queueLeft.offer(pollLeft.right);
               queueRight.offer(pollRight.left);
            }
         }
      }

      return queueLeft.isEmpty() && queueRight.isEmpty();
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
