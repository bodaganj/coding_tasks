package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

   public static void main(String[] args) {
      TreeNode tn3 = new TreeNode(3);
      TreeNode tn5 = new TreeNode(5);
      TreeNode tn4 = new TreeNode(4, tn3, tn5);
      TreeNode tn1 = new TreeNode(1);
      TreeNode tn2 = new TreeNode(2, tn1, tn4);
      List<List<Integer>> lists = levelOrder(tn2);
      System.out.println(lists);
   }

   public static List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> ans = new ArrayList<>();
      if (root == null) {
         return ans;
      }
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      while (!queue.isEmpty()) {
         int size = queue.size();
         List<Integer> tmp = new ArrayList<>();
         for (int i = 0; i < size; i++) {
            TreeNode curr = queue.poll();
            if (curr != null) {
               tmp.add(curr.val);
               queue.add(curr.left);
               queue.add(curr.right);
            }
         }
         if (!tmp.isEmpty()) {
            ans.add(tmp);
         }
      }

      return ans;
   }

   public static class TreeNode {

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
