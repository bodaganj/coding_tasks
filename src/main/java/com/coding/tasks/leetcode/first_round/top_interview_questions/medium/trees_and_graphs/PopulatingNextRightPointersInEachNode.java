package com.coding.tasks.leetcode.first_round.top_interview_questions.medium.trees_and_graphs;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {

   public static void main(String[] args) {
      Node node7 = new Node(7);
      Node node6 = new Node(6);
      Node node5 = new Node(5);
      Node node4 = new Node(4);
      Node node3 = new Node(3, node6, node7, null);
      Node node2 = new Node(2, node4, node5, null);
      Node node1 = new Node(1, node2, node3, null);
      Node connect = connect(node1);
      System.out.println(connect);
   }

   /**
    * This is BFS solution with O(n) space complexity (WHICH IS NOT WHAT WE NEED)
    */
   private static Node connect(Node root) {
      if (root == null) {
         return null;
      }

      Queue<Node> queue = new LinkedList<>();
      queue.add(root);

      while (!queue.isEmpty()) {
         int size = queue.size();
         Node prev = null;
         while (size-- > 0) {
            Node poll = queue.poll();
            poll.next = prev;
            prev = poll;
            if (poll.right != null) {
               queue.add(poll.right);
               queue.add(poll.left);
            }
         }
      }

      return root;
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
