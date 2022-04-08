package com.coding.tasks.leetcode.first_round.top_interview_questions.medium.trees_and_graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {

   public static void main(String[] args) {
      TreeNode t7 = new TreeNode(7);
      TreeNode t15 = new TreeNode(15);
      TreeNode t20 = new TreeNode(20, t15, t7);
      TreeNode t9 = new TreeNode(9);
      TreeNode t3 = new TreeNode(3, t9, t20);
      System.out.println(zigzagLevelOrder(t3));
   }

   private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      if (root == null) {
         return Collections.emptyList();
      }

      List<List<Integer>> result = new ArrayList<>();
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);

      boolean reverse = true;
      while (!queue.isEmpty()) {
         int size = queue.size();
         LinkedList<Integer> list = new LinkedList<>();
         while (size-- > 0) {
            TreeNode poll = queue.poll();
            if (poll == null) {
               continue;
            }

            if (reverse) {
               list.addFirst(poll.val);
            } else {
               list.addLast(poll.val);
            }
            queue.add(poll.right);
            queue.add(poll.left);
         }

         if (list.isEmpty()) {
            continue;
         }

         reverse = !reverse;
         result.add(list);
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
