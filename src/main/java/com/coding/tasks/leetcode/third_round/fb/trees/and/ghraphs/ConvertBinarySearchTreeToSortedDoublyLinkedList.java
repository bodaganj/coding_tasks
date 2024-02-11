package com.coding.tasks.leetcode.third_round.fb.trees.and.ghraphs;

import java.util.Stack;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {

   public static void main(String[] args) {
      Node node3 = new Node(3);
      Node node1 = new Node(1);
      Node node5 = new Node(5);
      Node node2 = new Node(2, node1, node3);
      Node node4 = new Node(4, node2, node5);
      System.out.println(treeToDoublyList(node4));
   }

   public static Node treeToDoublyList(Node root) {
      if (root == null) {
         return null;
      }
      Node dummy = new Node(0);
      Node prev = dummy;
      Stack<Node> stack = new Stack<>();
      Node curr = root;

      while (!stack.isEmpty() || curr != null) {
         while (curr != null) {
            stack.push(curr);
            curr = curr.left;
         }

         curr = stack.pop();
         prev.right = curr;
         curr.left = prev;
         prev = curr;
         curr = curr.right;
      }
      dummy.right.left = prev;
      prev.right = dummy.right;
      return dummy.right;
   }

   // Definition for a Node.
   static class Node {

      public int val;
      public Node left;
      public Node right;

      public Node() {
      }

      public Node(int _val) {
         val = _val;
      }

      public Node(int _val, Node _left, Node _right) {
         val = _val;
         left = _left;
         right = _right;
      }
   }
}
