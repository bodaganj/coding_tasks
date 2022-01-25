package com.coding.tasks.cracking.the.code.trees_and_graphs;

public class CheckBalanced {

   private static int min = Integer.MAX_VALUE;
   private static int max = Integer.MIN_VALUE;

   public static void main(String[] args) {
      TreeNode tn3 = new TreeNode(3);
      TreeNode tn5 = new TreeNode(5);
      TreeNode tn4 = new TreeNode(4, tn3, tn5);
      TreeNode tn1 = new TreeNode(1);
      TreeNode tn2 = new TreeNode(2, tn1, tn4);

      System.out.println(isBalanced(tn2));

      TreeNode tn33 = new TreeNode(3);
      TreeNode tn66 = new TreeNode(6);
      TreeNode tn55 = new TreeNode(5, null, tn66);
      TreeNode tn44 = new TreeNode(4, tn33, tn55);
      TreeNode tn11 = new TreeNode(1);
      TreeNode tn22 = new TreeNode(2, tn11, tn44);

      System.out.println(isBalanced(tn22));
   }

   /**
    * The idea is the following:
    * 1. Get list of all depths
    * 2. Get min and max lengths and compare whether dif is <= 1
    * @param root
    * @return
    */
   private static boolean isBalanced(TreeNode root) {
      rec(root, 1);
      return max - min <= 1;
   }

   private static void rec(TreeNode node, Integer currDepth) {
      if (node.left != null) {
         rec(node.left, currDepth + 1);
      }

      if (node.right != null) {
         rec(node.right, currDepth + 1);
      }

      if (node.left == node.right) {
         max = Math.max(max, currDepth);
         min = Math.min(min, currDepth);
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
