package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.linked.list;

public class ReverseLinkedList {

   public static void main(String[] args) {
      ListNode l3 = new ListNode(3, null);
      ListNode l2 = new ListNode(2, l3);
      ListNode l1 = new ListNode(1, l2);

      ListNode tmp = l1;
      while (tmp != null) {
         System.out.print(tmp.val + " ");
         tmp = tmp.next;
      }

//      tmp = reverseListIter(l1);
      tmp = reverseListRec(l1);
      System.out.println();

      while (tmp != null) {
         System.out.print(tmp.val + " ");
         tmp = tmp.next;
      }
   }

   public static ListNode reverseListIter(ListNode head) {
      if (head == null) {
         return null;
      }

      ListNode curr = head;
      ListNode prev = null;
      while (curr != null) {
         ListNode tmp = curr.next;
         curr.next = prev;
         prev = curr;
         curr = tmp;
      }

      return prev;
   }

   public static ListNode reverseListRec(ListNode head) {
      if (head == null) {
         return null;
      }

      return rec(head, null);
   }

   private static ListNode rec(ListNode head, ListNode prev) {
      if (head == null) {
         return prev;
      }
      ListNode tmp = head.next;
      head.next = prev;
      prev = head;
      head = tmp;
      return rec(head, prev);
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
