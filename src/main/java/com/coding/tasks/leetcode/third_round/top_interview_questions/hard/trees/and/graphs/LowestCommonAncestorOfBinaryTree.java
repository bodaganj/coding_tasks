package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.trees.and.graphs;

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

      TreeNode t22 = new TreeNode(2);
      TreeNode t11 = new TreeNode(1, t22, null);
      System.out.println(lowestCommonAncestor(t11, t22, t11).val);
   }

   public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      Queue<TreeNode> nodesQueue = new LinkedList<>();
      Queue<List<TreeNode>> parentsQueue = new LinkedList<>();
      List<TreeNode> pList = null;
      List<TreeNode> qList = null;
      nodesQueue.add(root);
      List<TreeNode> initial = new ArrayList<>();
      initial.add(root);
      parentsQueue.add(initial);

      while (pList == null || qList == null) {
         int size = nodesQueue.size();
         while (size > 0) {
            TreeNode poll = nodesQueue.poll();
            List<TreeNode> parents = parentsQueue.poll();
            if (poll == q) {
               qList = parents;
            } else if (poll == p) {
               pList = parents;
            }

            if (poll.left != null) {
               List<TreeNode> tmp = new ArrayList<>(parents);
               tmp.add(poll.left);
               nodesQueue.add(poll.left);
               parentsQueue.add(tmp);
            }
            if (poll.right != null) {
               List<TreeNode> tmp = new ArrayList<>(parents);
               tmp.add(poll.right);
               nodesQueue.add(poll.right);
               parentsQueue.add(tmp);
            }
            size--;
         }
      }

      TreeNode ans = pList.get(0);
      int index = 1;
      while (index < pList.size() && index < qList.size()) {
         if (pList.get(index) == qList.get(index)) {
            ans = pList.get(index);
         } else {
            return ans;
         }
         index++;
      }
      return ans;
   }

   public static class TreeNode {

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
