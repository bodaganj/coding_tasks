package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.trees_and_graphs;

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
      System.out.println(inorderTraversalRec(t1));
      System.out.println(inorderTraversalIter(t1));
   }

   private static List<Integer> inorderTraversalRec(TreeNode root) {
      if (root == null) {
         return Collections.emptyList();
      } else {
         List<Integer> ans = new ArrayList<>();
         recursion(root, ans);
         return ans;
      }
   }

   private static void recursion(TreeNode root, List<Integer> ans) {
      if (root != null) {
         recursion(root.left, ans);
         ans.add(root.val);
         recursion(root.right, ans);
      }
   }

   private static List<Integer> inorderTraversalIter(TreeNode root) {
      if (root == null) {
         return Collections.emptyList();
      }

      Set<TreeNode> visited = new HashSet<>();
      List<Integer> ans = new ArrayList<>();
      Stack<TreeNode> stack = new Stack<>();
      stack.add(root);
      while (!stack.isEmpty()) {
         while (stack.peek().left != null && !visited.contains(stack.peek().left)) {
            stack.add(stack.peek().left);
         }
         TreeNode pop = stack.pop();
         visited.add(pop);
         ans.add(pop.val);
         if (pop.right != null && !visited.contains(pop.right)) {
            stack.add(pop.right);
         }
      }
      return ans;
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
