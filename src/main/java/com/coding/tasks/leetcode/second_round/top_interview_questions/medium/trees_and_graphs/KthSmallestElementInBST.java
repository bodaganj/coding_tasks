package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.trees_and_graphs;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBST {

   public static void main(String[] args) {
      TreeNode t1 = new TreeNode(1);
      TreeNode t4 = new TreeNode(4);
      TreeNode t2 = new TreeNode(2, t1, null);
      TreeNode t6 = new TreeNode(6);
      TreeNode t3 = new TreeNode(3, t2, t4);
      TreeNode t5 = new TreeNode(5, t3, t6);
      System.out.println(kthSmallest(t5, 3));

      TreeNode t44 = new TreeNode(4);
      TreeNode t22 = new TreeNode(2);
      TreeNode t11 = new TreeNode(1, null, t22);
      TreeNode t33 = new TreeNode(3, t11, t44);
      System.out.println(kthSmallest(t33, 1));
   }

   private static int kthSmallest(TreeNode root, int k) {
      List<Integer> list = new ArrayList<>();
      rec(root, list);
      return list.get(k - 1);
   }

   private static void rec(TreeNode root, List<Integer> list) {
      if (root != null) {
         rec(root.left, list);
         list.add(root.val);
         rec(root.right, list);
      }
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
