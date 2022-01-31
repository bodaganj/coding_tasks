package com.coding.tasks.leetcode.top.interview.questions.hard.trees_and_graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LowestCommonAncestorOfBinaryTree {

   public static void main(String[] args) {
      TreeNode t7 = new TreeNode(7);
      TreeNode t4 = new TreeNode(4);
      TreeNode t2 = new TreeNode(2, t7, t4);
      TreeNode t6 = new TreeNode(6);
      TreeNode t5 = new TreeNode(5, t6, t2);
      TreeNode t0 = new TreeNode(0);
      TreeNode t8 = new TreeNode(8);
      TreeNode t1 = new TreeNode(1, t0, t8);
      TreeNode t3 = new TreeNode(3, t5, t1);

      System.out.println(lowestCommonAncestor(t3, t5, t1).val);
      System.out.println(lowestCommonAncestor(t3, t5, t4).val);
      System.out.println(lowestCommonAncestor(t3, t6, t4).val);
   }

   // bfs
   private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      List<List<TreeNode>> paths = getPaths(root, p, q);

      List<TreeNode> firstPath = paths.get(0);
      List<TreeNode> secondPath = paths.get(1);
      TreeNode prev = root;

      for (int i = 1; i < firstPath.size(); i++) {
         if (firstPath.get(i) != secondPath.get(i)) {
            return prev;
         } else {
            prev = firstPath.get(i);
         }
      }

      return prev;
   }

   private static List<List<TreeNode>> getPaths(TreeNode root, TreeNode p, TreeNode q) {
      List<List<TreeNode>> finalList = new ArrayList<>();

      // queue of all TreeNodes
      Queue<TreeNode> queue = new LinkedList<>(); // O(N)
      queue.offer(root);

      // queue of parents per TreeNode
      Queue<List<TreeNode>> parentsQueue = new LinkedList<>();
      parentsQueue.offer(List.of(root));

      while (finalList.size() < 2 && !queue.isEmpty()) {
         TreeNode treeNodePoll = queue.poll();
         List<TreeNode> parentsListPoll = parentsQueue.poll();

         // if our current node is p or q then add all the parents of this node to final list
         if (treeNodePoll == p || treeNodePoll == q) {
            finalList.add(parentsListPoll);
         }

         if (treeNodePoll.left != null) {
            queue.offer(treeNodePoll.left);

            ArrayList<TreeNode> tmp = new ArrayList<>();
            tmp.addAll(parentsListPoll);
            tmp.add(treeNodePoll.left);
            parentsQueue.offer(tmp);
         }
         if (treeNodePoll.right != null) {
            queue.offer(treeNodePoll.right);

            ArrayList<TreeNode> tmp = new ArrayList<>();
            tmp.addAll(parentsListPoll);
            tmp.add(treeNodePoll.right);
            parentsQueue.offer(tmp);
         }
      }

      return finalList;
   }

   static class TreeNode {

      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int x) {
         val = x;
      }

      TreeNode(int x, TreeNode left, TreeNode right) {
         val = x;
         this.left = left;
         this.right = right;
      }
   }
}
