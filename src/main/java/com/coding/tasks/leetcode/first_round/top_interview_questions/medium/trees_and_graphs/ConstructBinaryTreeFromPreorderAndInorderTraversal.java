package com.coding.tasks.leetcode.first_round.top_interview_questions.medium.trees_and_graphs;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

   private final Map<Integer, Integer> map = new HashMap<>();
   private int preOrderIndex;

   public static void main(String[] args) {
      ConstructBinaryTreeFromPreorderAndInorderTraversal ob = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
      TreeNode treeNode1 = ob.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
      System.out.println(treeNode1);

      TreeNode treeNode2 = ob.buildTree(new int[]{1, 2}, new int[]{2, 1});
      System.out.println(treeNode2);

      TreeNode treeNode3 = ob.buildTree(new int[]{1, 2}, new int[]{1, 2});
      System.out.println(treeNode3);

      TreeNode treeNode4 = ob.buildTree(new int[]{1, 2, 3}, new int[]{3, 2, 1});
      System.out.println(treeNode4);

      TreeNode treeNode5 = ob.buildTree(new int[]{-1}, new int[]{-1});
      System.out.println(treeNode5);
   }

   private TreeNode buildTree(int[] preorder, int[] inorder) {
      preOrderIndex = 0;
      for (int i = 0; i < inorder.length; i++) {
         map.put(inorder[i], i);
      }
      return rec(preorder, 0, inorder.length - 1);
   }

   private TreeNode rec(int[] preorder, int left, int right) {
      if (left > right) {
         return null;
      }

      int rootValue = preorder[preOrderIndex++];
      int rootValueIndex = map.get(rootValue);

      TreeNode leftNode = rec(preorder, left, rootValueIndex - 1);
      TreeNode rightNode = rec(preorder, rootValueIndex + 1, right);

      return new TreeNode(rootValue, leftNode, rightNode);
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
