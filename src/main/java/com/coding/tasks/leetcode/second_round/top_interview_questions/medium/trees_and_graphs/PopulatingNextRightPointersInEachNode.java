package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.trees_and_graphs;

public class PopulatingNextRightPointersInEachNode {

   public static void main(String[] args) {
      Node node7 = new Node(7);
      Node node6 = new Node(6);
      Node node5 = new Node(5);
      Node node4 = new Node(4);
      Node node3 = new Node(3, node6, node7, null);
      Node node2 = new Node(2, node4, node5, null);
      Node node1 = new Node(1, node2, node3, null);
//      Node connect = connect(node1);
//      System.out.println(connect);
//   }
//
//   private static Node connect(Node root) {
   }

   static class Node {

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
}
