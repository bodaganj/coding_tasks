package com.coding.tasks.leetcode.third_round.fb.trees.and.ghraphs;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

   public static void main(String[] args) {

   }

   public static List<String> binaryTreePaths(TreeNode root) {
      List<String> ans = new ArrayList<>();
      rec(root, "", ans);
      return ans;
   }

   private static void rec(TreeNode node, String currentList, List<String> ans) {
      if (node.left == null && node.right == null) {
         ans.add(currentList + node.val);
      } else {
         if (node.left != null) {
            rec(node.left, currentList + node.val + "->", ans);
         }
         if (node.right != null) {
            rec(node.right, currentList + node.val + "->", ans);
         }
      }
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
