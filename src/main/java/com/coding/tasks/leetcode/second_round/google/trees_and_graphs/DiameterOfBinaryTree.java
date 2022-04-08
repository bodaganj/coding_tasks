package com.coding.tasks.leetcode.second_round.google.trees_and_graphs;

public class DiameterOfBinaryTree {

   public static void main(String[] args) {
      DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();

      TreeNode tn5 = new TreeNode(5);
      TreeNode tn4 = new TreeNode(4);
      TreeNode tn3 = new TreeNode(3);
      TreeNode tn2 = new TreeNode(2, tn4, tn5);
      TreeNode tn1 = new TreeNode(1, tn2, tn3);

//      System.out.println(diameterOfBinaryTree.diameterOfBinaryTree(tn1));
//      for (TreeNode treeNode : diameterOfBinaryTree.maxPath) {
//         System.out.print(treeNode.val + " -> ");
//      }
//      System.out.println();
//
//      TreeNode t14 = new TreeNode(14);
//      TreeNode t13 = new TreeNode(13, null, t14);
//      TreeNode t12 = new TreeNode(12);
//      TreeNode t11 = new TreeNode(11, null, t13);
//      TreeNode t10 = new TreeNode(10);
//      TreeNode t9 = new TreeNode(9, null, t10);
//      TreeNode t8 = new TreeNode(8);
//      TreeNode t7 = new TreeNode(7);
//      TreeNode t6 = new TreeNode(6, t8, t9);
//      TreeNode t5 = new TreeNode(5, t6, t7);
//      TreeNode t4 = new TreeNode(4);
//      TreeNode t3 = new TreeNode(3, t4, t5);
//      TreeNode t2 = new TreeNode(2, t12, t11);
//      TreeNode t1 = new TreeNode(1, t2, t3);
//
//      System.out.println(diameterOfBinaryTree.diameterOfBinaryTree(t1));
//      for (TreeNode treeNode : diameterOfBinaryTree.maxPath) {
//         System.out.print(treeNode.val + " -> ");
//      }
//      System.out.println();
//   }
//
//   public int diameterOfBinaryTree(TreeNode root) {
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
