package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.linked_lists;

public class CopyListWithRandomPointer {

   public static void main(String[] args) {
      Node n7 = new Node(7);
      Node n13 = new Node(13);
      Node n11 = new Node(11);
      Node n10 = new Node(10);
      Node n1 = new Node(1);

      n7.next = n13;
      n13.next = n11;
      n11.next = n10;
      n10.next = n1;

      n13.random = n7;
      n11.random = n1;
      n10.random = n11;
      n1.random = n7;

      Node node = copyRandomList(n7);
      while (node != null) {
         System.out.println("val -> " + node.val);
         System.out.println("random ->" + (node.random == null ? null : node.random.val));
         System.out.println();
         node = node.next;
      }
      System.out.println("----------------------");

      while (n7 != null) {
         System.out.println("val -> " + n7.val);
         System.out.println("random ->" + (n7.random == null ? null : n7.random.val));
         System.out.println();
         n7 = n7.next;
      }
   }

   private static Node copyRandomList(Node head) {
      if (head == null) {
         return null;
      }

      // create new nodes between existed nodes
      Node dummy = new Node(0);
      Node tmp = head;
      dummy.next = tmp;
      while (tmp != null) {
         Node newNode = new Node(tmp.val);
         newNode.next = tmp.next;
         tmp.next = newNode;
         tmp = newNode.next;
      }

      // map random references
      tmp = dummy.next;
      while (tmp != null && tmp.next != null) {
         if (tmp.random != null) {
            tmp.next.random = tmp.random.next;
         }
         tmp = tmp.next.next;
      }

      // remove references between all nodes and new nodes
      tmp = dummy;
      Node prev = tmp.next;
      while (tmp.next != null) {
         tmp.next = tmp.next.next;
         tmp = tmp.next;
         prev.next = tmp.next;
         prev = prev.next;
      }

      return dummy.next;
   }

   static class Node {

      int val;
      Node next;
      Node random;

      public Node(int val) {
         this.val = val;
         this.next = null;
         this.random = null;
      }
   }
}
