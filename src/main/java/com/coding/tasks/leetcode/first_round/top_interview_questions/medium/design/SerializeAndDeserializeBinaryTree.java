package com.coding.tasks.leetcode.first_round.top_interview_questions.medium.design;

import java.util.LinkedList;
import java.util.Queue;

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
      String serialize = ser.serialize(n1);
      TreeNode ans = deser.deserialize(serialize);
      pr(ans);
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

   // Your Codec object will be instantiated and called as such:
   // Codec ser = new Codec();
   // Codec deser = new Codec();
   // TreeNode ans = deser.deserialize(ser.serialize(root));
   static class Codec {

      // Encodes a tree to a single string.
      public String serialize(TreeNode root) {
         if (root == null) {
            return "null";
         }

         StringBuilder sb = new StringBuilder();
         Queue<TreeNode> queue = new LinkedList<>();
         queue.offer(root);
         sb.append(root.val);

         while (!queue.isEmpty()) {
            int size = queue.size();
            int counter = 0;

            while (counter < size) {
               TreeNode poll = queue.poll();

               if (poll.left == null) {
                  sb.append("n");
               } else {
                  queue.offer(poll.left);
                  sb.append(poll.left.val);
               }
               if (poll.right == null) {
                  sb.append("n");
               } else {
                  queue.offer(poll.right);
                  sb.append(poll.right.val);
               }

               counter++;
            }
         }

         return sb.toString();
      }

      // Decodes your encoded data to tree.
      public TreeNode deserialize(String data) {
         if (data.equals("null")) {
            return null;
         }
         TreeNode root = new TreeNode(Integer.parseInt(data.charAt(0) + ""));
         Queue<TreeNode> queue = new LinkedList<>();
         queue.offer(root);
         char[] chars = data.toCharArray();
         int charsCounter = 1;

         while (!queue.isEmpty()) {
            int size = queue.size();
            int counter = 0;

            while (counter < size) {
               TreeNode poll = queue.poll();

               if (chars[charsCounter] == 'n') {
                  poll.left = null;
               } else {
                  TreeNode left = new TreeNode(Integer.parseInt(chars[charsCounter] + ""));
                  poll.left = left;
                  queue.offer(left);
               }
               charsCounter++;

               if (chars[charsCounter] == 'n') {
                  poll.right = null;
               } else {
                  TreeNode right = new TreeNode(Integer.parseInt(chars[charsCounter] + ""));
                  poll.right = right;
                  queue.offer(right);
               }
               charsCounter++;

               counter++;
            }
         }

         return root;
      }
   }
}
