package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.trees_and_graphs;

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
      List<List<Integer>> ans = new ArrayList<>();
      if (root != null) {
         boolean zigZagFlag = false;
         Queue<TreeNode> queue = new LinkedList<>();
         queue.offer(root);

         while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            while (size > 0) {
               size--;
               TreeNode poll = queue.poll();
               tmp.add(poll.val);

               if (poll.left != null) {
                  queue.offer(poll.left);
               }
               if (poll.right != null) {
                  queue.offer(poll.right);
               }
            }

            if (zigZagFlag) {
               Collections.reverse(tmp);
            }
            ans.add(tmp);
            zigZagFlag = !zigZagFlag;
         }
      }
      return ans;
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
