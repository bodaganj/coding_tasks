package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.linked_lists;

public class OddEvenLinkedList {

   public static void main(String[] args) {
      ListNode l5 = new ListNode(5);
      ListNode l4 = new ListNode(4, l5);
      ListNode l3 = new ListNode(3, l4);
      ListNode l2 = new ListNode(2, l3);
      ListNode l1 = new ListNode(1, l2);

      ListNode listNode = oddEvenList(l1);

      while (listNode != null) {
         System.out.println(listNode.val);
         listNode = listNode.next;
      }
   }

   private static ListNode oddEvenList(ListNode head) {
      return null;
   }

   static class ListNode {

      int val;
      ListNode next;

      ListNode() {
      }

      ListNode(int val) {
         this.val = val;
      }

      ListNode(int val, ListNode next) {
         this.val = val;
         this.next = next;
      }
   }
}
