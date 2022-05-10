package com.coding.tasks.leetcode.second_round.google.design;

import java.util.Collections;
import java.util.LinkedList;

public class SerializeAndDeserializeBinaryTree {

   public static void main(String[] args) {
      TreeNode n5 = new TreeNode(5);
      TreeNode n4 = new TreeNode(4);
      TreeNode n3 = new TreeNode(3);
      TreeNode n2 = new TreeNode(2);
      TreeNode n1 = new TreeNode(1);
      n1.left = n2;
      n1.right = n3;
      n3.left = n4;
      n3.right = n5;

      pr(n1);
      System.out.println("============");
      Codec ser = new Codec();
      Codec deser = new Codec();
      String serialize = ser.serialize(n1);
      System.out.println(serialize);
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

   static class Codec {

      public String serialize(TreeNode root) {
         StringBuilder sb = new StringBuilder();
         recSer(root, sb);
         return sb.substring(0, sb.length() - 1);
      }

      public TreeNode deserialize(String data) {
         String[] split = data.split(",");
         LinkedList<String> list = new LinkedList<>();
         Collections.addAll(list, split);

         return recDes(list);
      }

      private void recSer(TreeNode node, StringBuilder sb) {
         if (node != null) {
            sb.append(node.val).append(",");
            recSer(node.left, sb);
            recSer(node.right, sb);
         } else {
            sb.append("#,");
         }
      }

      private TreeNode recDes(LinkedList<String> split) {
         if (!split.isEmpty()) {
            if (!split.get(0).equals("#")) {
               TreeNode node = new TreeNode(Integer.parseInt(split.removeFirst()));
               node.left = recDes(split);
               node.right = recDes(split);
               return node;
            } else {
               split.removeFirst();
            }
         }
         return null;
      }
   }

   static public class TreeNode {

      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int x) {
         val = x;
      }
   }
}
