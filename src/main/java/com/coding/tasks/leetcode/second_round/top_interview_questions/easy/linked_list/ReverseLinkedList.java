package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.linked_list;

public class ReverseLinkedList {

   public static void main(String[] args) {
//      ListNode l3 = new ListNode(3, null);
//      ListNode l2 = new ListNode(2, l3);
//      ListNode l1 = new ListNode(1, l2);
//
//      ListNode tmp = l1;
//      while (tmp != null) {
//         System.out.print(tmp.val + " ");
//         tmp = tmp.next;
//      }
//
//      tmp = reverseList(l1);
//      System.out.println();
//
//      while (tmp != null) {
//         System.out.print(tmp.val + " ");
//         tmp = tmp.next;
//      }
//   }
//
//   private static ListNode reverseList(ListNode head) {
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
