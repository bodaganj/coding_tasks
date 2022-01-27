package com.coding.tasks.cracking.the.code.trees_and_graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Subtree {

   public static void main(String[] args) {
      TreeNode tn3 = new TreeNode(3);
      TreeNode tn5 = new TreeNode(5);
      TreeNode tn4 = new TreeNode(4, tn3, tn5);
      TreeNode tn1 = new TreeNode(1);
      TreeNode tn2 = new TreeNode(2, tn1, tn4);

      TreeNode tn33 = new TreeNode(3);
      TreeNode tn55 = new TreeNode(5);
      TreeNode tn44 = new TreeNode(4, tn33, tn55);

      TreeNode tn7 = new TreeNode(7);
      TreeNode tn9 = new TreeNode(9);
      TreeNode tn8 = new TreeNode(8, tn7, tn9);

      System.out.println(isSubtree(tn2, tn44));
      System.out.println(isSubtree(tn2, tn8));

      TreeNode tn11 = new TreeNode(1);
      TreeNode tn1111 = new TreeNode(1, tn11, null);
      TreeNode tn111 = new TreeNode(1);
      System.out.println(isSubtree(tn1111, tn111));

      TreeNode t0 = new TreeNode(0);
      TreeNode t2 = new TreeNode(2);
      TreeNode t1 = new TreeNode(1, t0, null);
      TreeNode t5 = new TreeNode(5);
      TreeNode t4 = new TreeNode(4, t1, t2);
      TreeNode t3 = new TreeNode(3, t4, t5);

      TreeNode tn222 = new TreeNode(2);
      TreeNode tn11111 = new TreeNode(1);
      TreeNode tn444 = new TreeNode(4, tn11111, tn222);
      System.out.println(isSubtree(t3, tn444));

      TreeNode n3 = new TreeNode(3);
      TreeNode n2 = new TreeNode(2);
      TreeNode n1 = new TreeNode(1, n2, n3);

      TreeNode n33 = new TreeNode(3);
      TreeNode n22 = new TreeNode(2, n33, null);
      System.out.println(isSubtree(n1, n22));
   }

   private static boolean isSubtree(TreeNode root, TreeNode subRoot) {
      // find a node in root equal to subRoot
      // return false if not present
      List<TreeNode> listOfPotentialNodes = getListOfPotentialNodes(root, subRoot);
      if (listOfPotentialNodes.isEmpty()) {
         return false;
      }

      // go with dfs while subRoot is not empty and compare
      for (TreeNode potentialRoot : listOfPotentialNodes) {
         if (checkIfSubRoot(potentialRoot, subRoot)) {
            return true;
         }
      }

      return false;
   }

   private static List<TreeNode> getListOfPotentialNodes(TreeNode root, TreeNode subRoot) {
      List<TreeNode> potentialRootList = new ArrayList<>();
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);

      while (!queue.isEmpty()) {
         TreeNode poll = queue.poll();

         if (poll == null) {
            continue;
         }

         if (poll.val == subRoot.val) {
            potentialRootList.add(poll);
         }

         queue.add(poll.right);
         queue.add(poll.left);
      }

      return potentialRootList;
   }

   private static boolean checkIfSubRoot(TreeNode potentialRoot, TreeNode subRoot) {
      if (potentialRoot.val != subRoot.val) {
         return false;
      }

      Queue<TreeNode> rootQueue = new LinkedList<>();
      rootQueue.add(potentialRoot.right);
      rootQueue.add(potentialRoot.left);

      Queue<TreeNode> subRootQueue = new LinkedList<>();
      subRootQueue.add(subRoot.right);
      subRootQueue.add(subRoot.left);

      while (!subRootQueue.isEmpty()) {
         TreeNode subRootPoll = subRootQueue.poll();
         TreeNode rootPoll = rootQueue.poll();

         if ((rootPoll == null && subRootPoll != null) || (subRootPoll == null && rootPoll != null)) {
            return false;
         }

         if (subRootPoll != rootPoll) {
            if (subRootPoll.val != rootPoll.val) {
               return false;
            } else {
               rootQueue.add(rootPoll.right);
               rootQueue.add(rootPoll.left);

               subRootQueue.add(subRootPoll.right);
               subRootQueue.add(subRootPoll.left);
            }
         }
      }

      return true;
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
