package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.linked_list;

public class MergeTwoSortedLists {

   public static void main(String[] args) {
      ListNode l4 = new ListNode(4, null);
      ListNode l2 = new ListNode(2, l4);
      ListNode l1 = new ListNode(1, l2);

      ListNode l44 = new ListNode(4, null);
      ListNode l33 = new ListNode(3, l44);
      ListNode l11 = new ListNode(1, l33);

      ListNode listNode = mergeTwoLists(l1, l11);

      ListNode tmp = listNode;
      while (tmp != null) {
         System.out.print(tmp.val + " ");
         tmp = tmp.next;
      }
   }

   private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      ListNode dummy = new ListNode(0);
      ListNode tmp = dummy;

      ListNode tmpL1 = l1;
      ListNode tmpL2 = l2;

      while (tmpL1 != null && tmpL2 != null) {
         if (tmpL1.val < tmpL2.val) {
            tmp.next = tmpL1;
            tmpL1 = tmpL1.next;
         } else {
            tmp.next = tmpL2;
            tmpL2 = tmpL2.next;
         }
         tmp = tmp.next;
      }

      while (tmpL1 != null) {
         tmp.next = tmpL1;
         tmpL1 = tmpL1.next;
         tmp = tmp.next;
      }
      while (tmpL2 != null) {
         tmp.next = tmpL2;
         tmpL2 = tmpL2.next;
         tmp = tmp.next;
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
