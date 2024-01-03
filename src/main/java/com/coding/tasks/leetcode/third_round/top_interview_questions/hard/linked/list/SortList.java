package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.linked.list;

public class SortList {

   public static void main(String[] args) {
      ListNode l1 = new ListNode(1);
      ListNode l2 = new ListNode(2, l1);
      ListNode l3 = new ListNode(3, l2);
      ListNode l4 = new ListNode(4, l3);
      ListNode dummy = sortList(l4);
      while (dummy != null) {
         System.out.print(dummy.val + " -> ");
         dummy = dummy.next;
      }
   }

   public static ListNode sortList(ListNode head) {
      if (head == null) {
         return null;
      }

      if (head.next == null) {
         return head;
      } else {
         int length = getLength(head);
         int mid = length / 2;

         ListNode tmpLeft = head;
         int i = 1;
         while (i < mid) {
            tmpLeft = tmpLeft.next;
            i++;
         }
         ListNode nextNode = tmpLeft.next;
         tmpLeft.next = null;
         ListNode left = sortList(head);
         ListNode right = sortList(nextNode);
         return merge(left, right);
      }
   }

   private static ListNode merge(ListNode node1, ListNode node2) {
      ListNode dummy = new ListNode();
      ListNode l = node1;
      ListNode r = node2;
      ListNode tmp = dummy;
      while (l != null && r != null) {
         if (l.val < r.val) {
            tmp.next = l;
            tmp = tmp.next;
            l = l.next;
         } else {
            tmp.next = r;
            tmp = tmp.next;
            r = r.next;
         }
      }

      if (l != null) {
         tmp.next = l;
      }
      if (r != null) {
         tmp.next = r;
      }
      return dummy.next;
   }

   private static int getLength(ListNode nodeLeft) {
      int length = 1;
      ListNode tmp = nodeLeft;
      while (tmp != null) {
         tmp = tmp.next;
         length++;
      }
      return length;
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
