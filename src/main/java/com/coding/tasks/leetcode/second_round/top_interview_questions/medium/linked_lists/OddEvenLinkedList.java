package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.linked_lists;

public class OddEvenLinkedList {

   public static void main(String[] args) {
      ListNode l6 = new ListNode(6);
      ListNode l5 = new ListNode(5, l6);
      ListNode l4 = new ListNode(4, l5);
      ListNode l3 = new ListNode(3, l4);
      ListNode l2 = new ListNode(2, l3);
      ListNode l1 = new ListNode(1, l2);

      ListNode listNode = oddEvenList(l1);

      while (listNode != null) {
         System.out.println(listNode.val);
         listNode = listNode.next;
      }
      System.out.println("========");
      ListNode l55 = new ListNode(5);
      ListNode l44 = new ListNode(4, l55);
      ListNode l33 = new ListNode(3, l44);
      ListNode l22 = new ListNode(2, l33);
      ListNode l11 = new ListNode(1, l22);

      ListNode listNode1 = oddEvenList(l11);

      while (listNode1 != null) {
         System.out.println(listNode1.val);
         listNode1 = listNode1.next;
      }
   }

   private static ListNode oddEvenList(ListNode head) {
      if (head == null) {
         return null;
      }

      ListNode even = head.next;
      ListNode tmpOdd = head;
      ListNode tmpEven = even;

      while (tmpOdd.next != null && tmpEven.next != null) {
         tmpOdd.next = tmpEven.next;
         tmpOdd = tmpOdd.next;

         tmpEven.next = tmpOdd.next;
         tmpEven = tmpEven.next;
      }

      tmpOdd.next = even;
      return head;
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
