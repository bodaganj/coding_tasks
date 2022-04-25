package com.coding.tasks.leetcode.second_round.google.trees_and_graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiameterOfBinaryTree {

   private static int maxPath = 0;
   private static List<TreeNode> maxPathNodes;

   public static void main(String[] args) {
      TreeNode tn5 = new TreeNode(5);
      TreeNode tn4 = new TreeNode(4);
      TreeNode tn3 = new TreeNode(3);
      TreeNode tn2 = new TreeNode(2, tn4, tn5);
      TreeNode tn1 = new TreeNode(1, tn2, tn3);

      System.out.println(diameterOfBinaryTree(tn1));
      System.out.println("==========");
      for (TreeNode maxPathNode : maxPathNodes) {
         System.out.println(maxPathNode.val);
      }
   }

   private static int diameterOfBinaryTree(TreeNode root) {
      maxPath = 0;
      getMaxPath(root);
      return maxPath;
   }

   private static List<TreeNode> getMaxPath(TreeNode node) {
      if (node == null) {
         return Collections.emptyList();
      } else {
         List<TreeNode> leftList = getMaxPath(node.left);
         List<TreeNode> rightList = getMaxPath(node.right);
         List<TreeNode> currentList = new ArrayList<>();
         currentList.addAll(leftList);
         currentList.addAll(rightList);
         currentList.add(node);

         if (maxPath < currentList.size() - 1) {
            maxPath = currentList.size() - 1;
            maxPathNodes = currentList;
         }

         List<TreeNode> ret = new ArrayList<>();
         if (leftList.size() > rightList.size()) {
            ret.addAll(leftList);
         } else {
            ret.addAll(rightList);
         }
         ret.add(node);
         return ret;
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
