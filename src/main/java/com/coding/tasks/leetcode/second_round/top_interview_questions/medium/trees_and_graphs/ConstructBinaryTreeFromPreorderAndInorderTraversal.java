package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.trees_and_graphs;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

   public static void main(String[] args) {
      TreeNode treeNode1 = buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
      System.out.println(treeNode1);

      TreeNode treeNode2 = buildTree(new int[]{1, 2}, new int[]{2, 1});
      System.out.println(treeNode2);

      TreeNode treeNode3 = buildTree(new int[]{1, 2}, new int[]{1, 2});
      System.out.println(treeNode3);

      TreeNode treeNode4 = buildTree(new int[]{1, 2, 3}, new int[]{3, 2, 1});
      System.out.println(treeNode4);

      TreeNode treeNode5 = buildTree(new int[]{-1}, new int[]{-1});
      System.out.println(treeNode5);
   }

   private static TreeNode buildTree(int[] preorder, int[] inorder) {
      // preorder array is used to get the root of tree/subtree
      // inorder array is used to see what nodes are going to the left subtree, what nodes are going to the right subtree
      return getSubTree(preorder, inorder, 0, inorder.length - 1);
   }

   private static TreeNode getSubTree(int[] preorder, int[] inorder, int left, int right) {
      if (left == right) {
         return new TreeNode(inorder[left]);
      } else if (left < right) {
         // create map of inorder_value -> index in order to find the root node (from preorder array) of this range [left; right]
         Map<Integer, Integer> map = new HashMap<>();
         int counter = left;
         while (counter <= right) {
            map.put(inorder[counter], counter);
            counter++;
         }

         int i = 0;
         while (!map.containsKey(preorder[i])) {
            i++;
         }
         Integer index = map.get(preorder[i]);

         TreeNode root = new TreeNode(preorder[i]);
         root.left = getSubTree(preorder, inorder, left, index - 1);
         root.right = getSubTree(preorder, inorder, index + 1, right);
         return root;
      } else {
         return null;
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
