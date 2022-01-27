package com.coding.tasks.cracking.the.code.trees_and_graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LowestCommonAncestorOfBinaryTree {

   public static void main(String[] args) {
      TreeNode tn0 = new TreeNode(0);
      TreeNode tn3 = new TreeNode(3);
      TreeNode tn5 = new TreeNode(5, null, tn0);
      TreeNode tn4 = new TreeNode(4, tn3, tn5);
      TreeNode tn1 = new TreeNode(1);
      TreeNode tn2 = new TreeNode(2, tn1, tn4);

      System.out.println(lowestCommonAncestor(tn2, tn0, tn1).val);
   }

   private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      List<TreeNode> pParents = getAllParents(root, p);
      List<TreeNode> qParents = getAllParents(root, q);

      for (int i = pParents.size() - 1; i >= 0; i--) {
         if (qParents.contains(pParents.get(i))) {
            return pParents.get(i);
         }
      }

      return null;
   }

   private static List<TreeNode> getAllParents(TreeNode root, TreeNode node) {
      Queue<TreeNode> queue = new LinkedList<>();
      Queue<List<TreeNode>> queueList = new LinkedList<>();
      queue.add(root);
      queueList.add(List.of(root));

      while (!queue.isEmpty()) {
         TreeNode poll = queue.poll();
         List<TreeNode> list = queueList.poll();

         if (poll == node) {
            return list;
         } else {
            if (poll.right != null) {
               queue.add(poll.right);
               List<TreeNode> tmp = new ArrayList<>(list);
               tmp.add(poll.right);
               queueList.add(tmp);
            }

            if (poll.left != null) {
               queue.add(poll.left);
               List<TreeNode> tmp = new ArrayList<>(list);
               tmp.add(poll.left);
               queueList.add(tmp);
            }
         }
      }

      return Collections.emptyList();
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
