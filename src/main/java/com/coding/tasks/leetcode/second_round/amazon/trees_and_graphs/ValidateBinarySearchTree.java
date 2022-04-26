package com.coding.tasks.leetcode.second_round.amazon.trees_and_graphs;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {

   public static void main(String[] args) {
      TreeNode tn6 = new TreeNode(6);
      TreeNode tn3 = new TreeNode(3);
      TreeNode tn4 = new TreeNode(4, tn3, tn6);
      TreeNode tn1 = new TreeNode(1);
      TreeNode tn5 = new TreeNode(5, tn1, tn4);

      System.out.println(isValidBST(tn5));

//      TreeNode tn111 = new TreeNode(-2147483648);
//
//      System.out.println(isValidBST(tn111));
   }

   private static boolean isValidBST(TreeNode root) {
      List<Integer> inOrderTraversal = new ArrayList<>();
      dfs(root, inOrderTraversal);
      for (int i = 1; i < inOrderTraversal.size(); i++) {
         if (inOrderTraversal.get(i - 1) >= inOrderTraversal.get(i)) {
            return false;
         }
      }

      return true;
   }

   private static void dfs(TreeNode root, List<Integer> inOrderTraversal) {
      if (root != null) {
         dfs(root.left, inOrderTraversal);
         inOrderTraversal.add(root.val);
         dfs(root.right, inOrderTraversal);
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
