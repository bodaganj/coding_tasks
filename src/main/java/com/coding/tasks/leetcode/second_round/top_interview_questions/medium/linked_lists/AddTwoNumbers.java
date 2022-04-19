package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.linked_lists;

public class AddTwoNumbers {

   public static void main(String[] args) {
      ListNode l1 = new ListNode(9);
      ListNode l2 = new ListNode(9, l1);
      ListNode l3 = new ListNode(9, l2);

      ListNode l4 = new ListNode(9);
      ListNode l5 = new ListNode(9, l4);
      ListNode l6 = new ListNode(9, l5);
      ListNode l7 = new ListNode(9, l6);

      ListNode listNode = addTwoNumbers(l3, l7);

      while (listNode != null) {
         System.out.println(listNode.val);
         listNode = listNode.next;
      }
   }

   private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      int carry = 0;
      ListNode dummy = new ListNode(0);
      ListNode tmp = dummy;
      ListNode l1Tmp = l1;
      ListNode l2Tmp = l2;
      while (l1Tmp != null && l2Tmp != null) {
         int value = l1Tmp.val + l2Tmp.val + carry;
         carry = value / 10;
         tmp.next = new ListNode(value % 10);
         tmp = tmp.next;
         l1Tmp = l1Tmp.next;
         l2Tmp = l2Tmp.next;
      }

      while (l1Tmp != null) {
         int value = l1Tmp.val + carry;
         carry = value / 10;
         tmp.next = new ListNode(value % 10);
         tmp = tmp.next;
         l1Tmp = l1Tmp.next;
      }
      while (l2Tmp != null) {
         int value = l2Tmp.val + carry;
         carry = value / 10;
         tmp.next = new ListNode(value % 10);
         tmp = tmp.next;
         l2Tmp = l2Tmp.next;
      }

      if (carry > 0) {
         tmp.next = new ListNode(1);
      }

      return dummy.next;
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
