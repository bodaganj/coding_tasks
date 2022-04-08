package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.design;

public class SerializeAndDeserializeBinaryTree {

   public static void main(String[] args) {
      TreeNode n5 = new TreeNode(-5, null, null);
      TreeNode n4 = new TreeNode(-4, null, null);
      TreeNode n3 = new TreeNode(-3, n4, n5);
      TreeNode n2 = new TreeNode(-2, null, null);
      TreeNode n1 = new TreeNode(-1, n2, n3);

      pr(n1);
      System.out.println("============");
      Codec ser = new Codec();
      Codec deser = new Codec();
//      String serialize = ser.serialize(n1);
//      TreeNode ans = deser.deserialize(serialize);
//      pr(ans);
   }

   private static void pr(TreeNode root) {
      if (root.left != null) {
         pr(root.left);
      }
      if (root.right != null) {
         pr(root.right);
      }
      System.out.println(root.val);
   }

   /**
    * Definition for a binary tree node.
    */
   static class TreeNode {

      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int x) {
         val = x;
      }

      TreeNode(int x, TreeNode left, TreeNode right) {
         val = x;
         this.left = left;
         this.right = right;
      }
   }

   static class Codec {

      // Encodes a tree to a single string.
//      public String serialize(TreeNode root) {
//      }
//
//      // Decodes your encoded data to tree.
//      public TreeNode deserialize(String data) {
//      }
   }
}
