package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.linked_lists;

public class AddTwoNumbers {

   public static void main(String[] args) {
//      ListNode l1 = new ListNode(9);
//      ListNode l2 = new ListNode(9, l1);
//      ListNode l3 = new ListNode(9, l2);
//
//      ListNode l4 = new ListNode(9);
//      ListNode l5 = new ListNode(9, l4);
//      ListNode l6 = new ListNode(9, l5);
//      ListNode l7 = new ListNode(9, l6);
//
//      ListNode listNode = addTwoNumbers(l3, l7);
//
//      while (listNode != null) {
//         System.out.println(listNode.val);
//         listNode = listNode.next;
//      }
//   }
//
//   private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
