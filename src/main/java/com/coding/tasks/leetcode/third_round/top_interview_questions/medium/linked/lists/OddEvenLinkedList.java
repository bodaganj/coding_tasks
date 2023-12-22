package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.linked.lists;

public class OddEvenLinkedList {

   public static void main(String[] args) {
//      ListNode l6 = new ListNode(6);
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

   public static ListNode oddEvenList(ListNode head) {
      if (head == null || head.next == null) {
         return head;
      }

      ListNode odd = head;
      ListNode even = head.next;
      ListNode dummyEven = even;
      ListNode dummy = odd;

      while (even != null && even.next != null) {
         odd.next = even.next;
         odd = odd.next;
         even.next = odd.next;
         even = even.next;
      }

      odd.next = dummyEven;
      return dummy;
   }

   public static class ListNode {

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
