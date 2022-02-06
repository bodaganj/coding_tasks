package com.coding.tasks.leetcode.amazon.trees_and_graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LowestCommonAncestorOfBinaryTree {

   public static void main(String[] args) {
      TreeNode tn4 = new TreeNode(4);
      TreeNode tn7 = new TreeNode(7);
      TreeNode tn8 = new TreeNode(8);
      TreeNode tn0 = new TreeNode(0);
      TreeNode tn2 = new TreeNode(2, tn7, tn4);
      TreeNode tn6 = new TreeNode(6);
      TreeNode tn1 = new TreeNode(1, tn0, tn8);
      TreeNode tn5 = new TreeNode(5, tn6, tn2);
      TreeNode tn3 = new TreeNode(3, tn5, tn1);

      System.out.println(lowestCommonAncestor(tn3, tn5, tn4).val);
   }

   private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if (p == root || q == root) {
         return root;
      }

      // get path from root to both node
      // search within the smallest list. Find the first element which differs on the same index and return previous.
      // if we finish the small list then return the last node of small list
      List<List<TreeNode>> fullPaths = getFullPaths(root, p, q);

      List<TreeNode> first = fullPaths.get(0);
      List<TreeNode> second = fullPaths.get(1);

      if (first.size() < second.size()) {
         return getResult(first, second);
      } else {
         return getResult(second, first);
      }
   }

   private static List<List<TreeNode>> getFullPaths(TreeNode root, TreeNode p, TreeNode q) {
      List<List<TreeNode>> result = new ArrayList<>();

      Stack<TreeNode> nodeStack = new Stack<>();
      Stack<List<TreeNode>> pathStack = new Stack<>();

      nodeStack.add(root);
      pathStack.add(List.of(root));

      while (!nodeStack.isEmpty() || result.size() != 2) {
         TreeNode pop = nodeStack.pop();
         List<TreeNode> pathPop = pathStack.pop();

         if (pop == q || pop == p) {
            result.add(pathPop);
         }

         TreeNode right = pop.right;
         TreeNode left = pop.left;

         if (right != null) {
            nodeStack.add(right);

            List<TreeNode> list = new ArrayList<>(pathPop);
            list.add(right);
            pathStack.add(list);
         }
         if (left != null) {
            nodeStack.add(left);

            List<TreeNode> list = new ArrayList<>(pathPop);
            list.add(left);
            pathStack.add(list);
         }
      }

      return result;
   }

   private static TreeNode getResult(List<TreeNode> first, List<TreeNode> second) {
      TreeNode prev = first.get(0);
      for (int i = 1; i < first.size(); i++) {
         if (first.get(i) != second.get(i)) {
            return prev;
         } else {
            prev = first.get(i);
         }
      }
      return first.get(first.size() - 1);
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
