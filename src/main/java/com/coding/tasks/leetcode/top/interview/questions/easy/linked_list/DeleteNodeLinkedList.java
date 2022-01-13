package com.coding.tasks.leetcode.top.interview.questions.easy.linked_list;

public class DeleteNodeLinkedList {

   private static void deleteNode(ListNode node) {
      node.val = node.next.val;
      node.next = node.next.next;
   }

   static class ListNode {

      int val;
      ListNode next;

      ListNode(int x) {
         val = x;
      }
   }
}
