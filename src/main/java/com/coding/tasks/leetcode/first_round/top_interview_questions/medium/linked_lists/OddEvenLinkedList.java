package com.coding.tasks.leetcode.first_round.top_interview_questions.medium.linked_lists;

public class OddEvenLinkedList {

   public static void main(String[] args) {
      ListNode l5 = new ListNode(5);
      ListNode l4 = new ListNode(4, l5);
      ListNode l3 = new ListNode(3, l4);
      ListNode l2 = new ListNode(2, l3);
      ListNode l1 = new ListNode(1, l2);

      ListNode listNode = oddEvenList(l1);

      while (listNode != null) {
         System.out.println(listNode.val);
         listNode = listNode.next;
      }
   }

   private static ListNode oddEvenList(ListNode head) {
      return null;
   }

   // This one is nice!!!!
//   private static ListNode oddEvenList(ListNode head) {
//      if (head == null) {
//         return null;
//      }
//      ListNode odd = head;
//      ListNode even = head.next;
//      ListNode evenHead = head.next;
//      // `even != null` rules out the list of only 1 node
//      // `even.next != null` rules out the list of only 2 nodes
//      while (even != null && even.next != null) {
//         // Put odd to the odd list
//         odd.next = odd.next.next;
//
//         // Put even to the even list
//         even.next = even.next.next;
//
//         // Move the pointer to the next odd/even
//         odd = odd.next;
//         even = even.next;
//      }
//      odd.next = evenHead;
//      return head;
//   }

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
