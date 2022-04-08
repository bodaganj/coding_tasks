package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.linked_lists;

public class IntersectionOfTwoLinkedLists {

   public static void main(String[] args) {

      ListNode l4 = new ListNode(4);
      ListNode l3 = new ListNode(3, l4);
      ListNode l2 = new ListNode(2, l3);
      ListNode l1 = new ListNode(1, l2);

      ListNode l6 = new ListNode(6);
      ListNode l7 = new ListNode(7, l6);
      ListNode l5 = new ListNode(5, l7);
//
//      ListNode listNode = getIntersectionNode(l1, l5);
//
//      if (listNode != null) {
//         System.out.println(listNode.val);
//      } else {
//         System.out.println("null");
//      }
//   }
//
//   private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
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
