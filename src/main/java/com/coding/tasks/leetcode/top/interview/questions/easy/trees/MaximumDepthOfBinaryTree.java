package com.coding.tasks.leetcode.top.interview.questions.easy.trees;

public class MaximumDepthOfBinaryTree {

//   [0,2,4,1,null,3,-1,5,1,null,6,null,8]

   public static void main(String[] args) {
      TreeNode tn7 = new TreeNode(7);
      TreeNode tn15 = new TreeNode(15);
      TreeNode tn20 = new TreeNode(20, tn15, tn7);
      TreeNode tn9 = new TreeNode(9);
      TreeNode tn3 = new TreeNode(3, tn9, tn20);

      System.out.println(maxDepth(tn3));

      TreeNode tn5 = new TreeNode(5);
      TreeNode tn1 = new TreeNode(1);
      TreeNode tn6 = new TreeNode(6);
      TreeNode tn8 = new TreeNode(8);
      TreeNode tn11 = new TreeNode(1, tn5, tn1);
      TreeNode tn33 = new TreeNode(3, null, tn6);
      TreeNode tn_1 = new TreeNode(-1, null, tn8);
      TreeNode tn2 = new TreeNode(2, tn11, null);
      TreeNode tn4 = new TreeNode(4, tn33, tn_1);
      TreeNode tn0 = new TreeNode(0, tn2, tn4);

      System.out.println(maxDepth(tn0));
   }

   // recursion
   private static int maxDepth(TreeNode root) {
      if (root == null) {
         return 0;
      } else {
         return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
      }
   }

   // bfs
//   private static int maxDepth(TreeNode root) {
//      int maxDepth = 0;
//      if (root == null) {
//         return maxDepth;
//      }
//
//      Queue<TreeNode> queue = new LinkedList<>();
//      queue.add(root);
//
//      while (!queue.isEmpty()) {
//         maxDepth += 1;
//
//         int size = queue.size();
//         for (int i = 0; i < size; i++) {
//            TreeNode poll = queue.poll();
//            if (poll.left != null) {
//               queue.add(poll.left);
//            }
//            if (poll.right != null) {
//               queue.add(poll.right);
//            }
//         }
//      }
//
//      return maxDepth;
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
