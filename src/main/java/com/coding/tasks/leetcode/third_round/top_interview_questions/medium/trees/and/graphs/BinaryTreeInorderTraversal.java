package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.trees.and.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

   public static void main(String[] args) {
      TreeNode t3 = new TreeNode(3);
      TreeNode t2 = new TreeNode(2, t3, null);
      TreeNode t1 = new TreeNode(1, null, t2);
      System.out.println(inorderTraversal(t1));
   }

   public static List<Integer> inorderTraversal(TreeNode root) {
      if (root == null) {
         return Collections.emptyList();
      }

      Set<TreeNode> seen = new HashSet<>();
      List<Integer> ans = new ArrayList<>();
      Stack<TreeNode> stack = new Stack<>();
      stack.add(root);
      seen.add(root);
      while (!stack.isEmpty()) {
         TreeNode peek = stack.peek();
         while (peek.left != null) {
            if (!seen.contains(peek.left)) {
               stack.add(peek.left);
               seen.add(peek.left);
            }
            peek = peek.left;
         }
         TreeNode pop = stack.pop();
         ans.add(pop.val);
         if (pop.right != null) {
            stack.add(pop.right);
         }
      }
      return ans;
   }

   public List<Integer> inorderTraversalRecursion(TreeNode root) {
      if (root == null) {
         return Collections.emptyList();
      }

      List<Integer> ans = new ArrayList<>();
      rec(root, ans);
      return ans;
   }

   private void rec(TreeNode node, List<Integer> ans) {
      if (node == null) {
         return;
      }

      rec(node.left, ans);
      ans.add(node.val);
      rec(node.right, ans);
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
