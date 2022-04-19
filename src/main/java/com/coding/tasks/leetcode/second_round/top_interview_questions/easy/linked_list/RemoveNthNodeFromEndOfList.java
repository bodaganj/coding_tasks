package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.linked_list;

public class RemoveNthNodeFromEndOfList {

   public static void main(String[] args) {
      ListNode l3 = new ListNode(3, null);
      ListNode l2 = new ListNode(2, l3);
      ListNode l1 = new ListNode(1, l2);

      ListNode tmp = l1;
      while (tmp != null) {
         System.out.print(tmp.val + " ");
         tmp = tmp.next;
      }
      tmp = removeNthFromEnd(l1, 1);
      System.out.println();

      while (tmp != null) {
         System.out.print(tmp.val + " ");
         tmp = tmp.next;
      }
      // ==============
      ListNode l333 = new ListNode(3, null);
      ListNode l222 = new ListNode(2, l3);
      System.out.println();
      System.out.println("======");
      tmp = l222;
      while (tmp != null) {
         System.out.print(tmp.val + " ");
         tmp = tmp.next;
      }
      tmp = removeNthFromEnd(l222, 1);
      System.out.println();

      while (tmp != null) {
         System.out.print(tmp.val + " ");
         tmp = tmp.next;
      }
      // ===========================
      System.out.println();
      System.out.println("======");
      ListNode l22 = new ListNode(2, null);

      tmp = l22;
      while (tmp != null) {
         System.out.print(tmp.val + " ");
         tmp = tmp.next;
      }
      tmp = removeNthFromEnd(l22, 1);
      System.out.println();

      while (tmp != null) {
         System.out.print(tmp.val + " ");
         tmp = tmp.next;
      }
   }

   private static ListNode removeNthFromEnd(ListNode head, int n) {
      // 1. Get length
      int length = 0;
      ListNode tmp = head;
      while (tmp != null) {
         length++;
         tmp = tmp.next;
      }

      // 2. Get node to be removed
      ListNode dummy = new ListNode(0, head);
      tmp = dummy;
      int counter = 0;
      while (counter < length - n) {
         tmp = tmp.next;
         counter++;
      }
      tmp.next = tmp.next.next;

      return dummy.next;
   }

   private static ListNode removeNthFromEndOneLoop(ListNode head, int n) {
      ListNode dummy = new ListNode(0, head);
      ListNode tmp = dummy;
      int counterRight = 0;
      int counterLeft = 0;
      ListNode toDelete = dummy;
      while (tmp != null) {
         tmp = tmp.next;
         counterRight++;
         if (counterRight - n > counterLeft + 1) {
            counterLeft++;
            toDelete = toDelete.next;
         }
      }
      toDelete.next = toDelete.next.next;

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

