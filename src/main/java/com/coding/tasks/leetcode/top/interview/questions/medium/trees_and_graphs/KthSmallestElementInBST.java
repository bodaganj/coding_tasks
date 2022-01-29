package com.coding.tasks.leetcode.top.interview.questions.medium.trees_and_graphs;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class KthSmallestElementInBST {

   public static void main(String[] args) {
      TreeNode t1 = new TreeNode(1);
      TreeNode t4 = new TreeNode(4);
      TreeNode t2 = new TreeNode(2, t1, null);
      TreeNode t6 = new TreeNode(6);
      TreeNode t3 = new TreeNode(3, t2, t4);
      TreeNode t5 = new TreeNode(5, t3, t6);
      System.out.println(kthSmallest(t5, 3));

//      TreeNode t4 = new TreeNode(4);
//      TreeNode t2 = new TreeNode(2);
//      TreeNode t1 = new TreeNode(1, null, t2);
//      TreeNode t3 = new TreeNode(3, t1, t4);
//      System.out.println(kthSmallest(t3, 1));
   }

   private static int kthSmallest(TreeNode root, int k) {
      Stack<TreeNode> stack = new Stack<>();
      stack.add(root);

      Set<TreeNode> seen = new HashSet<>();
      int counter = 1;
      while (!stack.isEmpty()) {
         TreeNode peek = stack.peek();
         while (peek.left != null && !seen.contains(peek.left)) {
            stack.add(peek.left);
            peek = peek.left;
         }

         TreeNode pop = stack.pop();
         seen.add(pop);
         if (counter == k) {
            return pop.val;
         } else {
            counter++;
            if (pop.right != null && !seen.contains(pop.right)) {
               stack.add(pop.right);
            }
         }
      }

      return 0;
   }

   /**
    * This one should be used!!!!
    */
//   public int kthSmallest(TreeNode root, int k) {
//      Stack<TreeNode> stack = new Stack<>();
//
//      while (true) {
//         while (root != null) {
//            stack.push(root);
//            root = root.left;
//         }
//         root = stack.pop();
//         if (--k == 0) {
//            return root.val;
//         }
//         root = root.right;
//      }
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
