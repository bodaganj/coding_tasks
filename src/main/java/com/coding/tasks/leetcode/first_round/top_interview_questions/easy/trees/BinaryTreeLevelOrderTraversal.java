package com.coding.tasks.leetcode.first_round.top_interview_questions.easy.trees;

import java.util.ArrayList;
import java.util.Collections;
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

   private static List<List<Integer>> levelOrder(TreeNode root) {
      if (root == null) {
         return Collections.emptyList();
      }

      List<List<Integer>> result = new ArrayList<>();
      result.add(List.of(root.val));

      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root.left);
      queue.add(root.right);

      while (!queue.isEmpty()) {
         List<Integer> newList = new ArrayList<>();

         int size = queue.size();

         while (size-- > 0) {
            TreeNode poll = queue.poll();

            if (poll != null) {
               newList.add(poll.val);
               queue.add(poll.left);
               queue.add(poll.right);
            }
         }
         if (!newList.isEmpty()) {
            result.add(newList);
         }
      }

      return result;
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
