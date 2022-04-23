package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.trees_and_graphs;

public class InorderSuccessorInBST {

   public static void main(String[] args) {
      TreeNode n1 = new TreeNode(1);
      TreeNode n2 = new TreeNode(2, n1, null);
      TreeNode n4 = new TreeNode(4);
      TreeNode n3 = new TreeNode(3, n2, n4);
      TreeNode n6 = new TreeNode(6);
      TreeNode n5 = new TreeNode(5, n3, n6);

      TreeNode treeNode = inorderSuccessor(n5, n6);
      System.out.println(treeNode == null ? "null" : treeNode.val);
   }

   private static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
      TreeNode prev = null;
      while (root != null) {
         if (root.val > p.val) {
            prev = root;
            root = root.left;
         } else {
            root = root.right;
         }
      }
      return prev;
   }

   // Stack
//   private static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//      if (root == p) {
//         return root.right;
//      }
//
//      boolean flag = false;
//      Stack<TreeNode> stack = new Stack<>();
//      while (true) {
//         while (root != null) {
//            stack.add(root);
//            root = root.left;
//         }
//         if (stack.isEmpty()) {
//            return null;
//         }
//         if (flag) {
//            return stack.pop();
//         }
//         root = stack.pop();
//         if (root == p && !stack.isEmpty()) {
//            flag = true;
//         }
//         root = root.right;
//      }
//   }

   // Inorder traversal with recursion
//   private static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//      List<TreeNode> list = new ArrayList<>();
//      rec(root, list);
//      for (int i = 0; i < list.size() - 1; i++) {
//         if (list.get(i) == p) {
//            return list.get(i + 1);
//         }
//      }
//      return null;
//   }
//
//   private static void rec(TreeNode node, List<TreeNode> list) {
//      if (node != null) {
//         rec(node.left, list);
//         list.add(node);
//         rec(node.right, list);
//      }
//   }

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
