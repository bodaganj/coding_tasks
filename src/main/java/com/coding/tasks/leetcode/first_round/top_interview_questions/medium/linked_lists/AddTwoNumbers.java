package com.coding.tasks.leetcode.first_round.top_interview_questions.medium.linked_lists;

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
      int extra = 0;
      ListNode fake = new ListNode(0);
      ListNode tmp = fake;

      while (l1 != null || l2 != null) {
         int l1Val = l1 == null ? 0 : l1.val;
         int l2Val = l2 == null ? 0 : l2.val;

         if (l1 != null) {
            l1 = l1.next;
         }
         if (l2 != null) {
            l2 = l2.next;
         }

         int currVal = l1Val + l2Val + extra;

         tmp.next = new ListNode(currVal % 10);
         extra = currVal / 10;
         tmp = tmp.next;

         if (l1 == null && l2 == null && extra == 1) {
            tmp.next = new ListNode(extra);
         }
      }

      return fake.next;
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
