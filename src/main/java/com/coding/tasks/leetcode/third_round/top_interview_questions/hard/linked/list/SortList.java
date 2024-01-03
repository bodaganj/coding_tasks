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
      if (head == null || head.next == null) {
         return head;
      }

      ListNode last = head;
      while (last.next != null) {
         last = last.next;
      }
      return sort(head, last);
   }

   private static ListNode sort(ListNode nodeLeft, ListNode nodeRight) {
      if (nodeLeft == nodeRight) {
         return nodeLeft;
      } else {
         int length = getLength(nodeLeft, nodeRight);
         int mid = length / 2;

         ListNode tmpLeft = nodeLeft;
         int i = 1;
         while (i < mid) {
            tmpLeft = tmpLeft.next;
            i++;
         }
         ListNode tmpRight = tmpLeft.next;
         tmpLeft.next = null;
         ListNode left = sort(nodeLeft, tmpLeft);
         ListNode right = sort(tmpRight, nodeRight);
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

   private static int getLength(ListNode nodeLeft, ListNode nodeRight) {
      int length = 1;
      ListNode tmp = nodeLeft;
      while (tmp != nodeRight) {
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
