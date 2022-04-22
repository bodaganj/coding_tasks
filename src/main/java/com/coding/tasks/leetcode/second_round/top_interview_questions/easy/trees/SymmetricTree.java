package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.trees;

public class SymmetricTree {

   public static void main(String[] args) {
      TreeNode tn3333 = new TreeNode(3);
      TreeNode tn2222 = new TreeNode(2);
      TreeNode tn1111 = new TreeNode(1, tn2222, tn3333);

      System.out.println(isSymmetric(tn1111));

      TreeNode tn4 = new TreeNode(4);
      TreeNode tn3 = new TreeNode(3);
      TreeNode tn234 = new TreeNode(2, tn4, tn3);
      TreeNode tn243 = new TreeNode(2, tn3, tn4);
      TreeNode tn1 = new TreeNode(1, tn234, tn243);

      System.out.println(isSymmetric(tn1));

      TreeNode tn333 = new TreeNode(3);
      TreeNode tn33 = new TreeNode(3);
      TreeNode tn222 = new TreeNode(2, null, tn333);
      TreeNode tn22 = new TreeNode(2, null, tn33);
      TreeNode tn11 = new TreeNode(1, tn22, tn222);

      System.out.println(isSymmetric(tn11));

      TreeNode tn0 = new TreeNode(0);
      TreeNode tn111 = new TreeNode(1, null, null);

      System.out.println(isSymmetric(tn111));
   }

   private static boolean isSymmetric(TreeNode root) {
      if (root == null) {
         return true;
      } else {
         return isSymmetricChildren(root.left, root.right);
      }
   }

   private static boolean isSymmetricChildren(TreeNode left, TreeNode right) {
      if (left == right) {
         return true;
      } else {
         if (left == null || right == null || left.val != right.val) {
            return false;
         } else {
            return isSymmetricChildren(left.left, right.right) && isSymmetricChildren(left.right, right.left);
         }
      }
   }

//   private static boolean isSymmetric(TreeNode root) {
//      if (root == null) {
//         return true;
//      }
//
//      Queue<TreeNode> queue = new LinkedList<>();
//      if (root.left == null && root.right != null || root.left != null && root.right == null) {
//         return false;
//      }
//
//      if (root.left != null) {
//         queue.offer(root.left);
//         queue.offer(root.right);
//      }
//
//      while (!queue.isEmpty()) {
//         if (queue.size() % 2 != 0) {
//            return false;
//         }
//
//         int size = queue.size();
//         while (size > 0) {
//            size = size - 2;
//            TreeNode leftPoll = queue.poll();
//            TreeNode rightPoll = queue.poll();
//            if (leftPoll.val != rightPoll.val) {
//               return false;
//            }
//
//            if (leftPoll.left != null && rightPoll.right == null || leftPoll.left == null && rightPoll.right != null) {
//               return false;
//            }
//            if (leftPoll.left != null) {
//               queue.offer(leftPoll.left);
//               queue.offer(rightPoll.right);
//            }
//
//            if (leftPoll.right != null && rightPoll.left == null || leftPoll.right == null && rightPoll.left != null) {
//               return false;
//            }
//            if (leftPoll.right != null) {
//               queue.offer(leftPoll.right);
//               queue.offer(rightPoll.left);
//            }
//         }
//      }
//
//      return queue.isEmpty();
//   }

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
