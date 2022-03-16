package com.coding.tasks.leetcode.amazon.designe;

public class SerializeAndDeserializeBinaryTree {

   public static void main(String[] args) {
//      TreeNode n5 = new TreeNode(-5, null, null);
//      TreeNode n4 = new TreeNode(-4, null, null);
//      TreeNode n3 = new TreeNode(-3, n4, n5);
//      TreeNode n2 = new TreeNode(-2, null, null);
//      TreeNode n1 = new TreeNode(-1, n2, n3);

//      TreeNode n5 = new TreeNode(5, null, null);
//      TreeNode n4 = new TreeNode(4, null, null);
//      TreeNode n3 = new TreeNode(3, n4, n5);
//      TreeNode n2 = new TreeNode(2, null, null);
//      TreeNode n1 = new TreeNode(1, n2, n3);

      TreeNode n1 = new TreeNode(1);

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

      private static int index = 0;

      // Encodes a tree to a single string.
      public String serialize(TreeNode root) {
         StringBuilder sb = new StringBuilder();
         recSer(root, sb);
         return sb.substring(0, sb.toString().length() - 1);
      }

      // Decodes your encoded data to tree.
      public TreeNode deserialize(String data) {
         index = 0;
         String[] split = data.split(",");
         TreeNode root = recDes(split);
         return root;
      }

      private void recSer(TreeNode root, StringBuilder sb) {
         if (root == null) {
            sb.append("n,");
         } else {
            sb.append(root.val).append(",");
            recSer(root.left, sb);
            recSer(root.right, sb);
         }
      }

      private TreeNode recDes(String[] split) {
         if (index >= split.length) {
            return null;
         }
         if (split[index].equals("n")) {
            index++;
            return null;
         } else {
            TreeNode node = new TreeNode(Integer.parseInt(split[index]));
            index++;

            node.left = recDes(split);
            node.right = recDes(split);

            return node;
         }
      }
   }

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
}
