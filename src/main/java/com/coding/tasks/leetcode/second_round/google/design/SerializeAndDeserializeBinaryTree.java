package com.coding.tasks.leetcode.second_round.google.design;

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

   static class Codec {

//      public String serialize(TreeNode root) {
//      }
//
//      public TreeNode deserialize(String data) {
//      }
//
//      private TreeNode recDeser(LinkedList<String> list) {
//      }

      private void recSer(StringBuilder sb, TreeNode node) {
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
