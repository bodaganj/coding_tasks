package com.coding.tasks.leetcode.top.interview.questions.easy.linked_list;

import java.util.Objects;

public class RemoveNthNodeFromEndOfList {

   public static void main(String[] args) {
      ListNode l3 = new ListNode(3, null);
      ListNode l2 = new ListNode(2, l3);
//      ListNode l2 = new ListNode(2, null);
      ListNode l1 = new ListNode(1, l2);

      ListNode tmp = l1;
      while (tmp != null) {
         System.out.print(tmp.val + " ");
         tmp = tmp.next;
      }
//      tmp = removeNthFromEnd(l1, 2);
      tmp = removeNthFromEnd(l1, 3);
      System.out.println();

      while (tmp != null) {
         System.out.print(tmp.val + " ");
         tmp = tmp.next;
      }
// ==============
      System.out.println();
      tmp = l3;
      while (tmp != null) {
         System.out.print(tmp.val + " ");
         tmp = tmp.next;
      }
//      tmp = removeNthFromEnd(l1, 2);
      tmp = removeNthFromEnd(l3, 1);
      System.out.println();

      while (tmp != null) {
         System.out.print(tmp.val + " ");
         tmp = tmp.next;
      }
   }

   private static ListNode removeNthFromEnd(ListNode head, int n) {
      if (Objects.isNull(head)) {
         return null;
      }

      int length = getListLength(head);
      if (length < n) {
         return null;
      }

      if (length == n) {
         return head.next;
      }

      int j = 1;
      ListNode prev = null;
      ListNode curr = head;
      while (j <= length - n + 1) {
         if (j == length - n + 1) {
            prev.next = curr.next;
         }
         prev = curr;
         curr = curr.next;

         j++;
      }

      return head;
   }

   private static int getListLength(ListNode head) {
      ListNode tmp = head;
      int counter = 1;

      while (tmp.next != null) {
         counter++;
         tmp = tmp.next;
      }
      return counter;
   }

   /**
    * This one should be used!!!
    */
//   private static ListNode removeNthFromEnd(ListNode head, int n) {
//      if (head == null || head.next == null) {
//         return null;
//      }
//      Map<Integer, ListNode> map = new HashMap<>();
//      int counter = 0;
//      ListNode fake = new ListNode(0, head);
//      ListNode tmp = fake;
//
//      while (!Objects.isNull(tmp)) {
//         counter++;
//         map.put(counter, tmp);
//         tmp = tmp.next;
//      }
//
//      map.get(counter - n).next = map.get(counter - n + 1).next;
//      return fake.next;
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

