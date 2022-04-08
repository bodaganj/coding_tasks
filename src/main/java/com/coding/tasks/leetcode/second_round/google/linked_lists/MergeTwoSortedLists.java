package com.coding.tasks.leetcode.second_round.google.linked_lists;

public class MergeTwoSortedLists {

   public static void main(String[] args) {
      ListNode l3 = new ListNode(3);
      ListNode l1 = new ListNode(1, l3);

      ListNode l5 = new ListNode(5);
      ListNode l4 = new ListNode(4, l5);
      ListNode l2 = new ListNode(2, l4);

//      ListNode listNode = mergeTwoLists(l1, l2);
//      System.out.println(listNode);
//   }
//
//   private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
   }

   static public class ListNode {

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
