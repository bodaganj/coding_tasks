package com.coding.tasks.leetcode.first_round.google.trees_and_graphs;

public class FlipEquivalentBinaryTrees {

   public static void main(String[] args) {
      TreeNode t8 = new TreeNode(8);
      TreeNode t7 = new TreeNode(7);
      TreeNode t6 = new TreeNode(6);
      TreeNode t5 = new TreeNode(5, t7, t8);
      TreeNode t4 = new TreeNode(4);
      TreeNode t3 = new TreeNode(3, t6, null);
      TreeNode t2 = new TreeNode(2, t4, t5);
      TreeNode t1 = new TreeNode(1, t2, t3);

      TreeNode n8 = new TreeNode(8);
      TreeNode n7 = new TreeNode(7);
      TreeNode n6 = new TreeNode(6);
      TreeNode n5 = new TreeNode(5, n8, n7);
      TreeNode n4 = new TreeNode(4);
      TreeNode n3 = new TreeNode(3, null, n6);
      TreeNode n2 = new TreeNode(2, n4, n5);
      TreeNode n1 = new TreeNode(1, n3, n2);

      System.out.println(flipEquiv(t1, n1));
   }

   /**
    * Recursion
    */
   private static boolean flipEquiv(TreeNode root1, TreeNode root2) {
      if (root1 == root2) {
         return true;
      }

      if (root1 == null || root2 == null || root1.val != root2.val) {
         return false;
      }

      return (flipEquiv(root1.left, root2.left) || flipEquiv(root1.left, root2.right)) &&
         (flipEquiv(root1.right, root2.right) || flipEquiv(root1.right, root2.left));
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
