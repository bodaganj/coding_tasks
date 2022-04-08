package com.coding.tasks.leetcode.second_round.google.linked_lists;

public class RemoveNthNode {

   public static void main(String[] args) {
//      ListNode l5 = new ListNode(5);
//      ListNode l4 = new ListNode(4, l5);
//      ListNode l3 = new ListNode(3, l4);
//      ListNode l2 = new ListNode(2, l3);
      ListNode l2 = new ListNode(2);
      ListNode l1 = new ListNode(1, l2);

//      ListNode listNode = removeNthFromEnd(l1, 2);
//      System.out.println(listNode);
//   }
//
//   private static ListNode removeNthFromEnd(ListNode head, int n) {
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
