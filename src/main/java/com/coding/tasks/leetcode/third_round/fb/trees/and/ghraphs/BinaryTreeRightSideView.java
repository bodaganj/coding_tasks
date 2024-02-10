package com.coding.tasks.leetcode.third_round.fb.trees.and.ghraphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

   public List<Integer> rightSideView(TreeNode root) {
      if (root == null) {
         return Collections.emptyList();
      }
      List<Integer> list = new ArrayList<>();

      Queue<TreeNode> levels = new LinkedList<>();
      levels.add(root);

      while (!levels.isEmpty()) {
         int size = levels.size();
         TreeNode poll = null;
         while (size > 0) {
            poll = levels.poll();
            if (poll.left != null) {
               levels.add(poll.left);
            }
            if (poll.right != null) {
               levels.add(poll.right);
            }
            size--;
         }
         list.add(poll.val);
      }

      return list;
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
