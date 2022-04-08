package com.coding.tasks.leetcode.first_round.amazon.trees_and_graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {

   public static void main(String[] args) {

   }

   /**
    * Or linked list might be used instead of reversing the list
    */
   private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      if (root == null) {
         return Collections.emptyList();
      }

      List<List<Integer>> result = new ArrayList<>();
      boolean order = true;
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);

      while (!queue.isEmpty()) {
         int size = queue.size();

         List<Integer> list = new ArrayList<>();
         while (size-- > 0) {
            TreeNode poll = queue.poll();
            list.add(poll.val);

            if (poll.left != null) {
               queue.offer(poll.left);
            }
            if (poll.right != null) {
               queue.offer(poll.right);
            }
         }

         if (!list.isEmpty()) {
            if (order) {
               result.add(list);
               order = false;
            } else {
               Collections.reverse(list);
               result.add(list);
               order = true;
            }
         }
      }

      return result;
   }

   public class TreeNode {

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
