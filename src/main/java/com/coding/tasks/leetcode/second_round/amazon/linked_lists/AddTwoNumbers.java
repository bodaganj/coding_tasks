package com.coding.tasks.leetcode.second_round.amazon.linked_lists;

public class AddTwoNumbers {

   public static void main(String[] args) {
//      ListNode l41 = new ListNode(4);
//      ListNode l6 = new ListNode(6, l41);
//      ListNode l5 = new ListNode(5, l6);
//
//      ListNode l3 = new ListNode(3);
//      ListNode l42 = new ListNode(4, l3);
//      ListNode l2 = new ListNode(2, l42);
//
//      ListNode listNode = addTwoNumbers(l5, l2);
//      System.out.println(listNode);

      ListNode l1 = new ListNode(9);
      ListNode l2 = new ListNode(9, l1);
      ListNode l3 = new ListNode(9, l2);

      ListNode l4 = new ListNode(9);
      ListNode l5 = new ListNode(9, l4);
      ListNode l6 = new ListNode(9, l5);
      ListNode l7 = new ListNode(9, l6);

//      ListNode listNode = addTwoNumbers(l3, l7);

//      while (listNode != null) {
//         System.out.println(listNode.val);
//         listNode = listNode.next;
//      }
   }

//   private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//   }

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
