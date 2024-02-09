package com.coding.tasks.leetcode.third_round.fb.trees.and.ghraphs;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTreeToLinkedList {

   public static void main(String[] args) {
      TreeNode tn6 = new TreeNode(6);
      TreeNode tn5 = new TreeNode(5, null, tn6);
      TreeNode tn4 = new TreeNode(4);
      TreeNode tn3 = new TreeNode(3);
      TreeNode tn2 = new TreeNode(2, tn3, tn4);
      TreeNode tn1 = new TreeNode(1, tn2, tn5);
      flatten(tn1);
   }

   public static void flatten(TreeNode root) {
      List<Integer> preOrderList = new ArrayList<>();
      preOrder(root, preOrderList);
      TreeNode dummy = root;
      for (int i = 1; i < preOrderList.size(); i++) {
         dummy.right = new TreeNode(preOrderList.get(i));
         dummy.left = null;
         dummy = dummy.right;
      }
   }

   private static void preOrder(TreeNode root, List<Integer> preOrderList) {
      if (root != null) {
         preOrderList.add(root.val);
         preOrder(root.left, preOrderList);
         preOrder(root.right, preOrderList);
      }
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
