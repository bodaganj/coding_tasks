package com.coding.tasks.leetcode.second_round.google.trees_and_graphs;

public class SerializeTreeToListWithAllWays {

   public static void main(String[] args) {
//      TreeNode tn5 = new TreeNode(5);
//      TreeNode tn4 = new TreeNode(4);
//      TreeNode tn3 = new TreeNode(3);
//      TreeNode tn2 = new TreeNode(2, tn4, tn5);
//      TreeNode tn1 = new TreeNode(1, tn2, tn3);
//
//      System.out.println(serWithDfsStack(tn1));
//      System.out.println(serWithDfsRecursion(tn1));
//      System.out.println(serWithBfs(tn1));
//   }
//
//   private static List<Integer> serWithDfsStack(TreeNode node) {
   }

   static public class TreeNode {

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
