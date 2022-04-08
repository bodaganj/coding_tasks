package com.coding.tasks.leetcode.first_round.google.trees_and_graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class SerializeTreeToListWithAllWays {

   private static List<Integer> treeNodes = new ArrayList<>();

   public static void main(String[] args) {
      TreeNode tn5 = new TreeNode(5);
      TreeNode tn4 = new TreeNode(4);
      TreeNode tn3 = new TreeNode(3);
      TreeNode tn2 = new TreeNode(2, tn4, tn5);
      TreeNode tn1 = new TreeNode(1, tn2, tn3);

      System.out.println(serWithDfsStack(tn1));
      System.out.println(serWithDfsRecursion(tn1));
      System.out.println(serWithBfs(tn1));
   }

   private static List<Integer> serWithDfsStack(TreeNode node) {
      List<Integer> output = new ArrayList<>();
      Set<TreeNode> seen = new HashSet<>();
      Stack<TreeNode> stack = new Stack<>();
      stack.add(node);

      while (!stack.isEmpty()) {
         TreeNode current = stack.pop();
         if (Objects.isNull(current)) {
            continue;
         }
         if (!seen.contains(current)) {
            output.add(current.val);
            seen.add(current);
            stack.add(current.right);
            stack.add(current.left);
         }
      }

      return output;
   }

   private static List<Integer> serWithDfsRecursion(TreeNode node) {
      if (!Objects.isNull(node)) {
         serWithDfsRecursion(node.left);
         serWithDfsRecursion(node.right);
         treeNodes.add(node.val);
      }
      return treeNodes;
   }

   private static List<Integer> serWithBfs(TreeNode node) {
      List<Integer> output = new ArrayList<>();
      Set<TreeNode> seen = new HashSet<>();
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(node);

      while (!queue.isEmpty()) {
         TreeNode current = queue.poll();
         if (Objects.isNull(current)) {
            continue;
         }
         if (!seen.contains(current)) {
            output.add(current.val);
            seen.add(current);
            queue.add(current.left);
            queue.add(current.right);
         }
      }

      return output;
   }

   static public class TreeNode {

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
