package com.coding.tasks.leetcode.first_round.google.design;

import java.util.Arrays;
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

//      TreeNode n1 = new TreeNode(1);

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

   static class Codec {

      public String serialize(TreeNode root) {
         StringBuilder sb = new StringBuilder();
         recSer(sb, root);
         return sb.toString();
      }

      public TreeNode deserialize(String data) {
         LinkedList<String> list = new LinkedList<>(Arrays.asList(data.split(",")));
         return recDeser(list);
      }

      private TreeNode recDeser(LinkedList<String> list) {
         if (list.isEmpty()) {
            return null;
         } else if (list.getFirst().equals("n")) {
            list.removeFirst();
            return null;
         } else {
            TreeNode root = new TreeNode(Integer.parseInt(list.getFirst()));
            list.removeFirst();

            root.left = recDeser(list);
            root.right = recDeser(list);

            return root;
         }
      }

      private void recSer(StringBuilder sb, TreeNode node) {
         if (node != null) {
            sb.append(node.val).append(",");
            recSer(sb, node.left);
            recSer(sb, node.right);
         } else {
            sb.append("n,");
         }
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

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
}
