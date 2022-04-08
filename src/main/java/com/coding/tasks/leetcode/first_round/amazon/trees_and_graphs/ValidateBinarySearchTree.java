package com.coding.tasks.leetcode.first_round.amazon.trees_and_graphs;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {

   public static void main(String[] args) {
      TreeNode tn0 = new TreeNode(0);
      TreeNode tn3 = new TreeNode(3);
//      TreeNode tn5 = new TreeNode(5, null, tn0);
      TreeNode tn5 = new TreeNode(5);
      TreeNode tn4 = new TreeNode(4, tn3, tn5);
      TreeNode tn1 = new TreeNode(1);
      TreeNode tn2 = new TreeNode(2, tn1, tn4);

      System.out.println(isValidBST(tn2));

      TreeNode tn111 = new TreeNode(-2147483648);

      System.out.println(isValidBST(tn111));
   }

   private static boolean isValidBST(TreeNode root) {
      if (root == null) {
         return false;
      }

      List<Integer> list = new ArrayList<>();
      dfs(root, list);

      if (list.size() == 1) {
         return true;
      }

      for (int i = 1; i < list.size(); i++) {
         if (list.get(i - 1) >= list.get(i)) {
            return false;
         }
      }
      return true;
   }

   private static void dfs(TreeNode node, List<Integer> list) {
      if (node != null) {
         dfs(node.left, list);
         list.add(node.val);
         dfs(node.right, list);
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
