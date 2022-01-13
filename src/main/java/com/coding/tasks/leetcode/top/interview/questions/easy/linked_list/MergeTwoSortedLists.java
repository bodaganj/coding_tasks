package com.coding.tasks.leetcode.top.interview.questions.easy.linked_list;

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
         System.out.println(tmp.val);
         tmp = tmp.next;
      }
   }

   private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      ListNode fake = new ListNode(0, null);

      ListNode tmp = fake;
      while (l1 != null || l2 != null) {
         int val1 = l1 != null ? l1.val : Integer.MAX_VALUE;
         int val2 = l2 != null ? l2.val : Integer.MAX_VALUE;

         if (val1 <= val2) {
            tmp.next = l1;
            l1 = l1.next;
         } else {
            tmp.next = l2;
            l2 = l2.next;
         }
         tmp = tmp.next;
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
