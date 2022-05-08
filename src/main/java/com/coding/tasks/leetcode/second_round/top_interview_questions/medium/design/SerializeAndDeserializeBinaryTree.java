package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.design;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

   public static void main(String[] args) {
      TreeNode n5 = new TreeNode(5, null, null);
      TreeNode n4 = new TreeNode(4, null, null);
      TreeNode n3 = new TreeNode(3, n4, n5);
      TreeNode n2 = new TreeNode(2, null, null);
      TreeNode n1 = new TreeNode(1, n2, n3);

      pr(n1);
      System.out.println("============");
      Codec ser = new Codec();
      Codec deser = new Codec();
      String serialize = ser.serialize(n1);
      System.out.println("ser - " + serialize);
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

   static class Codec {

      // Encodes a tree to a single string.
      public String serialize(TreeNode root) {
         if (root == null) {
            return null;
         }

         StringBuilder sb = new StringBuilder();
         Queue<TreeNode> queue = new LinkedList<>();
         queue.offer(root);
         sb.append(root.val).append(",");

         while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
               TreeNode poll = queue.poll();

               if (poll.left != null) {
                  sb.append(poll.left.val).append(",");
                  queue.offer(poll.left);
               } else {
                  sb.append("#,");
               }
               if (poll.right != null) {
                  sb.append(poll.right.val).append(",");
                  queue.offer(poll.right);
               } else {
                  sb.append("#,");
               }
            }
         }

         return sb.substring(0, sb.length());
      }

      // Decodes your encoded data to tree.
      public TreeNode deserialize(String data) {
         if (data == null) {
            return null;
         }

         String[] split = data.split(",");
         TreeNode root = new TreeNode(Integer.parseInt(split[0]));
         Queue<TreeNode> queue = new LinkedList<>();
         queue.offer(root);

         int i = 1;
         while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
               TreeNode poll = queue.poll();

               if (i < split.length && !split[i].equals("#")) {
                  int val = Integer.parseInt(split[i]);
                  TreeNode left = new TreeNode(val);
                  poll.left = left;
                  queue.offer(left);
               }
               i++;

               if (i < split.length && !split[i].equals("#")) {
                  int val = Integer.parseInt(split[i]);
                  TreeNode right = new TreeNode(val);
                  poll.right = right;
                  queue.offer(right);
               }
               i++;
            }
         }

         return root;
      }
   }
}
