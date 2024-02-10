package com.coding.tasks.leetcode.third_round.fb.trees.and.ghraphs;

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
    Node highestLeft = getYourHighest(root.left);
    root.left = highestLeft;
    highestLeft.right = root;

    Node smallestRight = getYourSmallest(root.right);
    root.right = smallestRight;
    smallestRight.left = root;

    Node head = highestLeft;
    while (head.left != null) {
      head = head.left;
    }

    Node tail = smallestRight;
    while (tail.right != null) {
      tail = tail.right;
    }

    head.left = tail;
    tail.right = head;
    return head;
  }

  private static Node getYourHighest(Node root) {
    if (root.right == null && root.left == null) {
      return root;
    }
    if (root.right != null) {
      return getYourHighest(root.right);
    } else {
      return root;
    }
  }

  private static Node getYourSmallest(Node root) {
    if (root.right == null && root.left == null) {
      return root;
    }
    if (root.left != null) {
      return getYourSmallest(root.left);
    } else {
      return root;
    }
  }

  // Definition for a Node.
  static class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

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
