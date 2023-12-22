package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.trees.and.graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

   public static void main(String[] args) {
      TreeNode treeNode1 = buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
      System.out.println(treeNode1);
   }

   public static TreeNode buildTree(int[] preorder, int[] inorder) {
      if (inorder.length == 0) {
         return null;
      }
      return rec(preorder, inorder, new HashSet<>());
   }

   public static TreeNode rec(int[] preorder, int[] inorder, Set<Integer> seen) {
      if (inorder.length == 0) {
         return null;
      }

      int notSeen = 0;
      while (notSeen < preorder.length) {
         if (!seen.contains(preorder[notSeen])) {
            seen.add(preorder[notSeen]);
            break;
         }
         notSeen++;
      }
      TreeNode treeNode = new TreeNode(preorder[notSeen]);

      int index = 0;
      while (index < inorder.length) {
         if (inorder[index] == preorder[notSeen]) {
            break;
         }
         index++;
      }

      int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
      int[] inRight = index + 1 <= inorder.length ? Arrays.copyOfRange(inorder, index + 1, inorder.length) : new int[]{};
      treeNode.left = rec(preorder, inLeft, seen);
      treeNode.right = rec(preorder, inRight, seen);
      return treeNode;
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
