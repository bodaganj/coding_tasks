package com.coding.tasks.leetcode.google.linked_lists;

public class CopyListWithRandomPointer {

   public Node copyRandomList(Node head) {
      return head;
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
