package com.coding.tasks.other;

public class LargestBSTSubtree {

   private static int largest;

   public static void main(String[] args) {
//      TreeNode tn7 = new TreeNode(7);
//      TreeNode tn8 = new TreeNode(8);
//      TreeNode tn1 = new TreeNode(1);
//      TreeNode tn15 = new TreeNode(15, null, tn7);
//      TreeNode tn5 = new TreeNode(5, tn1, tn8);
//      TreeNode tn10 = new TreeNode(10, tn5, tn15);
//      System.out.println(largestBSTSubtree(tn10));

      TreeNode tn2 = new TreeNode(2, null, null);
      TreeNode tn1 = new TreeNode(1, tn2, null);
      System.out.println(largestBSTSubtree(tn1));

//      TreeNode t1 = new TreeNode(1);
//      TreeNode tn222 = new TreeNode(2, t1, null);
//      TreeNode t5 = new TreeNode(5);
//      TreeNode tn3 = new TreeNode(3);
//      TreeNode tn22 = new TreeNode(2, tn222, null);
//      TreeNode t7 = new TreeNode(7, t5, null);
//      TreeNode tn2 = new TreeNode(2, tn22, tn3);
//      TreeNode tn4 = new TreeNode(4, tn2, t7);
//      System.out.println(largestBSTSubtree(tn4));
   }

   private static int largestBSTSubtree(TreeNode root) {
      if (root == null) {
         return 0;
      }

      largest = 1;
      Status status = isBST(root);
      largest = Math.max(largest, status.amountOfNodes);
      return largest;
   }

   private static Status isBST(TreeNode node) {
      if (node.left == null && node.right == null) {
         return new Status(true, 1, node.val, node.val);
      } else if (node.left == null) {
         Status right = isBST(node.right);
         if (right.isBST && right.min > node.val) {
            int amountOfCurrentBSTNodes = right.amountOfNodes + 1;
            largest = Math.max(largest, amountOfCurrentBSTNodes);
            return new Status(true, amountOfCurrentBSTNodes, node.val, right.max);
         } else {
            return new Status(false, 0, 0, 0);
         }
      } else if (node.right == null) {
         Status left = isBST(node.left);
         if (left.isBST && left.max < node.val) {
            int amountOfCurrentBSTNodes = left.amountOfNodes + 1;
            largest = Math.max(largest, amountOfCurrentBSTNodes);
            return new Status(true, amountOfCurrentBSTNodes, left.min, node.val);
         } else {
            return new Status(false, 0, 0, 0);
         }
      } else {
         Status left = isBST(node.left);
         Status right = isBST(node.right);

         if (left.isBST && right.isBST && left.max < node.val && right.min > node.val) {
            int amountOfCurrentBSTNodes = left.amountOfNodes + right.amountOfNodes + 1;
            largest = Math.max(largest, amountOfCurrentBSTNodes);
            return new Status(true, amountOfCurrentBSTNodes, left.min, right.max);
         } else {
            return new Status(false, 0, 0, 0);
         }
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

   static class Status {

      boolean isBST;
      int amountOfNodes;
      int min;
      int max;

      public Status(boolean isBST, int amountOfNodes, int min, int max) {
         this.isBST = isBST;
         this.amountOfNodes = amountOfNodes;
         this.max = max;
         this.min = min;
      }
   }
}
