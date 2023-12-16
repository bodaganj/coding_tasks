package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.linked.list;

public class DeleteNodeInLinkedList {

   public void deleteNode(ListNode node) {
      node.val = node.next.val;
      node.next = node.next.next;
   }

   public class ListNode {

      int val;
      ListNode next;

      ListNode(int x) {
         val = x;
      }
   }
}
