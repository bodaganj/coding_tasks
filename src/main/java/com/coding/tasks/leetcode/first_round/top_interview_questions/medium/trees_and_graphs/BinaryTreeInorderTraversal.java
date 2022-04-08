package com.coding.tasks.leetcode.first_round.top_interview_questions.medium.trees_and_graphs;

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
      }

      List<Integer> list = new ArrayList<>();
      rec(root, list);

      return list;
   }

   private static void rec(TreeNode node, List<Integer> list) {
      if (node.left != null) {
         rec(node.left, list);
      }
      list.add(node.val);
      if (node.right != null) {
         rec(node.right, list);
      }
   }

   private static List<Integer> inorderTraversalIter(TreeNode root) {
      if (root == null) {
         return Collections.emptyList();
      }

      List<Integer> finalList = new ArrayList<>();
      Set<TreeNode> seen = new HashSet<>();
      Stack<TreeNode> stack = new Stack<>();
      stack.add(root);

      while (!stack.isEmpty()) {
         TreeNode pop = stack.pop();
         if (seen.contains(pop)) {
            continue;
         }

         if (pop.right != null && !seen.contains(pop.right)) {
            stack.add(pop.right);
         }

         stack.add(pop);

         if (pop.left != null && !seen.contains(pop.left)) {
            stack.add(pop.left);
         } else {
            finalList.add(pop.val);
            seen.add(pop);
            stack.pop();
         }
      }

      return finalList;
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
