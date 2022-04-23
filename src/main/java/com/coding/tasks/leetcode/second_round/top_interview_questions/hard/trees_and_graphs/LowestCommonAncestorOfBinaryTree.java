package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.trees_and_graphs;

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

   private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      List<TreeNode> pList = new ArrayList<>();
      List<TreeNode> qList = new ArrayList<>();
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);

      Queue<List<TreeNode>> nodes = new LinkedList<>();
      List<TreeNode> tmp = new ArrayList<>();
      tmp.add(root);
      nodes.offer(tmp);

      while (pList.isEmpty() || qList.isEmpty()) {
         int size = queue.size();
         while (size > 0) {
            TreeNode poll = queue.poll();
            List<TreeNode> list = nodes.poll();
            if (poll == p) {
               pList = list;
            } else if (poll == q) {
               qList = list;
            }

            if (poll.left != null) {
               queue.offer(poll.left);
               List<TreeNode> newList = new ArrayList<>(list);
               newList.add(poll.left);
               nodes.offer(newList);
            }
            if (poll.right != null) {
               queue.offer(poll.right);
               List<TreeNode> newList = new ArrayList<>(list);
               newList.add(poll.right);
               nodes.offer(newList);
            }

            size--;
         }
      }

      return getCommon(pList, qList);
   }

   private static TreeNode getCommon(List<TreeNode> pList, List<TreeNode> qList) {
      int counter = 1;
      while (counter < qList.size() && counter < pList.size()) {
         if (qList.get(counter) != pList.get(counter)) {
            return qList.get(counter - 1);
         }
         counter++;
      }

      if (counter == qList.size()) {
         return qList.get(qList.size() - 1);
      }

      return pList.get(pList.size() - 1);
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
