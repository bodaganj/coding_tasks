package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.linked.list;

public class MergeTwoSortedLists {

   public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      ListNode tmpList1 = list1;
      ListNode tmpList2 = list2;
      ListNode dummy = new ListNode();
      ListNode ans = dummy;

      while (tmpList1 != null && tmpList2 != null) {
         if (tmpList1.val < tmpList2.val) {
            ans.next = tmpList1;
            ans = ans.next;
            tmpList1 = tmpList1.next;
         } else {
            ans.next = tmpList2;
            ans = ans.next;
            tmpList2 = tmpList2.next;
         }
      }

      if (tmpList1 == null && tmpList2 != null) {
         ans.next = tmpList2;
      }
      if (tmpList2 == null && tmpList1 != null) {
         ans.next = tmpList1;
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
