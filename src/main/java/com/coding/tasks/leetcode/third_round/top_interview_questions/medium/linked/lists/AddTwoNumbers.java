package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.linked.lists;

public class AddTwoNumbers {

   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode dummy = new ListNode();
      ListNode tmp = dummy;
      int carry = 0;
      while (l1 != null || l2 != null) {
         int val1 = l1 == null ? 0 : l1.val;
         int val2 = l2 == null ? 0 : l2.val;

         int sum = val1 + val2 + carry;
         if (sum > 9) {
            carry = 1;
            sum %= 10;
         } else {
            carry = 0;
         }
         tmp.next = new ListNode(sum);
         tmp = tmp.next;

         l1 = l1 == null ? null : l1.next;
         l2 = l2 == null ? null : l2.next;
      }

      if (carry == 1) {
         tmp.next = new ListNode(1);
      }

      return dummy.next;
   }

   public class ListNode {

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
