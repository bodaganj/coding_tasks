package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.trees.and.graphs;

public class PopulatingNextRightPointersInEachNode {

   public Node connect(Node root) {
      if (root == null) {
         return null;
      }
      rec(root.left, root);
      rec(root.right, root);
      return root;
   }

   private void rec(Node node, Node parent) {
      if (node != null) {
         if (parent.right != node) {
            node.next = parent.right;
         } else if (parent.next != null) {
            node.next = parent.next.left;
         }

         rec(node.left, node);
         rec(node.right, node);
      }
   }

   class Node {

      public int val;
      public Node left;
      public Node right;
      public Node next;

      public Node() {
      }

      public Node(int _val) {
         val = _val;
      }

      public Node(int _val, Node _left, Node _right, Node _next) {
         val = _val;
         left = _left;
         right = _right;
         next = _next;
      }
   }

   ;
}
