package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.linked.list;

public class RemoveNthNodeFromEndOfList {

   public static void main(String[] args) {
      ListNode l5 = new ListNode(5, null);
      ListNode l4 = new ListNode(4, l5);
      ListNode l3 = new ListNode(3, l4);
      ListNode l2 = new ListNode(2, l3);
      ListNode l1 = new ListNode(1, l2);

      ListNode tmp = l1;
      while (tmp != null) {
         System.out.print(tmp.val + " ");
         tmp = tmp.next;
      }
      tmp = removeNthFromEnd(l1, 5);
      System.out.println();

      while (tmp != null) {
         System.out.print(tmp.val + " ");
         tmp = tmp.next;
      }

      // ===============================================
//      ListNode l11 = new ListNode(1, null);
//
//      ListNode tmp1 = l11;
//      while (tmp1 != null) {
//         System.out.print(tmp1.val + " ");
//         tmp1 = tmp1.next;
//      }
//      tmp1 = removeNthFromEnd(l11, 1);
//      System.out.println();
//
//      while (tmp1 != null) {
//         System.out.print(tmp1.val + " ");
//         tmp1 = tmp1.next;
//      }

      // ==========================================
      // ===============================================
//      ListNode l2 = new ListNode(2, null);
//      ListNode l1 = new ListNode(1, l2);
//
//      ListNode tmp1 = l1;
//      while (tmp1 != null) {
//         System.out.print(tmp1.val + " ");
//         tmp1 = tmp1.next;
//      }
//      tmp1 = removeNthFromEnd(l1, 1);
//      System.out.println();
//
//      while (tmp1 != null) {
//         System.out.print(tmp1.val + " ");
//         tmp1 = tmp1.next;
//      }
   }

   public static ListNode removeNthFromEnd(ListNode head, int n) {
      int left = 0;
      int right = 0;

      ListNode newNode = new ListNode();
      newNode.next = head;
      ListNode tmpRight = newNode;
      ListNode tmpLeft = newNode;
      while (tmpRight.next != null) {
         tmpRight = tmpRight.next;
         right++;
         if (right - n > left) {
            left++;
            tmpLeft = tmpLeft.next;
         }
      }

      if (tmpLeft.next.next != null) {
         tmpLeft.next = tmpLeft.next.next;
      } else {
         tmpLeft.next = null;
      }

      return newNode.next;
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
