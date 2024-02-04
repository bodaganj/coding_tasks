package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class ValidateBinarySearchTree {

   public static void main(String[] args) {
      TreeNode tn10 = new TreeNode(10);
      TreeNode tn8 = new TreeNode(8);
      TreeNode tn9 = new TreeNode(9, tn8, tn10);
      TreeNode tn4 = new TreeNode(4);
      TreeNode tn1 = new TreeNode(1);
      TreeNode tn3 = new TreeNode(3, tn1, tn4);
      TreeNode tn5 = new TreeNode(5, tn3, tn9);
      System.out.println(isValidBST(tn5));
   }

   public static boolean isValidBST(TreeNode root) {
      if (root == null) {
         return true;
      }
      List<Integer> list = new ArrayList<>();
//      iter(root, list);
      rec(root, list);
      Integer prev = list.get(0);
      for (int i = 1; i < list.size(); i++) {
         if (prev >= list.get(i)) {
            return false;
         } else {
            prev = list.get(i);
         }
      }
      return true;
   }

   private static void iter(TreeNode node, List<Integer> list) {
      Stack<TreeNode> stack = new Stack<>();
      stack.add(node);
      Set<TreeNode> seen = new HashSet<>();
      seen.add(node);
      while (!stack.isEmpty()) {
         TreeNode dummy = stack.peek();
         while (dummy.left != null) {
            if (!seen.contains(dummy.left)) {
               stack.add(dummy.left);
               seen.add(dummy.left);
            }
            dummy = dummy.left;
         }
         TreeNode pop = stack.pop();
         list.add(pop.val);
         if (pop.right != null && !seen.contains(pop.right)) {
            stack.add(pop.right);
            seen.add(pop.right);
         }
      }
   }

   private static void rec(TreeNode node, List<Integer> list) {
      if (node == null) {
         return;
      }
      rec(node.left, list);
      list.add(node.val);
      rec(node.right, list);
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
