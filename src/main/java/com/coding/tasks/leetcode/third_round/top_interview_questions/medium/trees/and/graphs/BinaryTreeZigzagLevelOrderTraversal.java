package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.trees.and.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {

   public static void main(String[] args) {
      TreeNode t5 = new TreeNode(5);
      TreeNode t4 = new TreeNode(4);
      TreeNode t3 = new TreeNode(3, null, t5);
      TreeNode t2 = new TreeNode(2, t4, null);
      TreeNode t1 = new TreeNode(1, t2, t3);
      System.out.println(zigzagLevelOrder(t1));
   }

   public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      List<List<Integer>> ans = new ArrayList<>();
      if (root == null) {
         return ans;
      }
      boolean startFromRight = true;
      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);

      while (!queue.isEmpty()) {
         int size = queue.size();
         LinkedList<Integer> tmp = new LinkedList<>();
         while (size > 0) {
            TreeNode poll = queue.poll();
            if (poll != null) {
               if (!startFromRight) {
                  tmp.add(poll.val);
               } else {
                  tmp.addFirst(poll.val);
               }
               queue.add(poll.right);
               queue.add(poll.left);
            }
            size--;
         }
         if (!tmp.isEmpty()) {
            ans.add(tmp);
         }
         startFromRight = !startFromRight;
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
