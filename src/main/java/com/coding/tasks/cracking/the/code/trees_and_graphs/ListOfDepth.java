package com.coding.tasks.cracking.the.code.trees_and_graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class ListOfDepth {

   private static List<List<Integer>> totalList = new ArrayList<>();

   public static void main(String[] args) {
      TreeNode tn6 = new TreeNode(6);
      TreeNode tn3 = new TreeNode(3);
      TreeNode tn5 = new TreeNode(5, null, tn6);
      TreeNode tn4 = new TreeNode(4, tn3, tn5);
      TreeNode tn1 = new TreeNode(1);
      TreeNode tn2 = new TreeNode(2, tn1, tn4);

      List<List<Integer>> lists1 = getAllDepthsDfs(tn2);
      List<List<Integer>> lists2 = getAllDepthsRec(tn2);
      List<List<Integer>> lists3 = getAllDepthsBfs(tn2);

      System.out.println(lists1);
      System.out.println(lists2);
      System.out.println(lists3);
   }

   // recursion
   private static List<List<Integer>> getAllDepthsRec(TreeNode root) {
      rec(root, new ArrayList<>());
      return totalList;
   }

   private static void rec(TreeNode node, List<Integer> listOfNodes) {
      if (node.left != null || node.right != null) {
         listOfNodes.add(node.val);

         if (node.left != null) {
            rec(node.left, new ArrayList<>(listOfNodes));
         }

         if (node.right != null) {
            rec(node.right, new ArrayList<>(listOfNodes));
         }
      }

      if (node.left == node.right) {
         listOfNodes.add(node.val);
         totalList.add(listOfNodes);
      }
   }

   // bfs
   private static List<List<Integer>> getAllDepthsBfs(TreeNode root) {
      List<List<Integer>> finalList = new ArrayList<>();

      Queue<Map<TreeNode, List<Integer>>> queue = new LinkedList<>();
      queue.add(Map.of(root, List.of(root.val)));

      while (!queue.isEmpty()) {
         Map<TreeNode, List<Integer>> poll = queue.poll();
         TreeNode treeNode = poll.keySet().stream().findFirst().get();

         if (treeNode.left == treeNode.right) {
            finalList.add(poll.get(treeNode));
         }

         if (treeNode.left != null) {
            ArrayList<Integer> tmp = new ArrayList<>(poll.get(treeNode));
            tmp.add(treeNode.left.val);
            queue.add(Map.of(treeNode.left, tmp));
         }

         if (treeNode.right != null) {
            ArrayList<Integer> tmp = new ArrayList<>(poll.get(treeNode));
            tmp.add(treeNode.right.val);
            queue.add(Map.of(treeNode.right, tmp));
         }
      }

      return finalList;
   }

   // dfs
   private static List<List<Integer>> getAllDepthsDfs(TreeNode root) {
      List<List<Integer>> finalList = new ArrayList<>();

      var stack = new Stack<Map<TreeNode, List<Integer>>>();
      stack.push(Map.of(root, List.of(root.val)));

      while (!stack.isEmpty()) {
         Map<TreeNode, List<Integer>> pop = stack.pop();
         TreeNode node = pop.keySet().stream().findFirst().get();

         if (node.left != null) {
            List<Integer> tmp = new ArrayList<>(pop.get(node));
            tmp.add(node.left.val);
            stack.push(Map.of(node.left, tmp));
         }

         if (node.right != null) {
            List<Integer> tmp = new ArrayList<>(pop.get(node));
            tmp.add(node.right.val);
            stack.push(Map.of(node.right, tmp));
         }

         if (node.left == node.right) {
            finalList.add(pop.get(node));
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
