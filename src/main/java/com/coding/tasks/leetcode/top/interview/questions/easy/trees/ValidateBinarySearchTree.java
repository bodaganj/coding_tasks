package com.coding.tasks.leetcode.top.interview.questions.easy.trees;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {

   public static void main(String[] args) {
      TreeNode tn0 = new TreeNode(0);
      TreeNode tn3 = new TreeNode(3);
      TreeNode tn5 = new TreeNode(5, null, tn0);
//      TreeNode tn5 = new TreeNode(5);
      TreeNode tn4 = new TreeNode(4, tn3, tn5);
      TreeNode tn1 = new TreeNode(1);
      TreeNode tn2 = new TreeNode(2, tn1, tn4);

      System.out.println(isValidBST(tn2));

      TreeNode tn111 = new TreeNode(-2147483648);

      System.out.println(isValidBST(tn111));
   }

   // Time = O(n)
   // Space = O(n)
   private static boolean isValidBST(TreeNode root) {
      List<Integer> list = new ArrayList<>();
      inOrderTraversal(root, list); // O(n)

      int min = list.get(0);
      for (int i = 1; i < list.size(); i++) { // O(n)
         int integer = list.get(i);
         if (min >= integer) {
            return false;
         } else {
            min = integer;
         }
      }
      return true;
   }

   private static void inOrderTraversal(TreeNode root, List<Integer> list) {
      if (root == null) {
         return;
      }
      inOrderTraversal(root.left, list);
      list.add(root.val);
      inOrderTraversal(root.right, list);
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
