package com.coding.tasks.leetcode.google.linked_lists;

import java.util.Objects;

public class AddTwoNumbers {

   public static void main(String[] args) {
//      ListNode l41 = new ListNode(4);
//      ListNode l6 = new ListNode(6, l41);
//      ListNode l5 = new ListNode(5, l6);
//
//      ListNode l3 = new ListNode(3);
//      ListNode l42 = new ListNode(4, l3);
//      ListNode l2 = new ListNode(2, l42);
//
//      ListNode listNode = addTwoNumbers(l5, l2);
//      System.out.println(listNode);

      ListNode l1 = new ListNode(9);
      ListNode l2 = new ListNode(9, l1);
      ListNode l3 = new ListNode(9, l2);

      ListNode l4 = new ListNode(9);
      ListNode l5 = new ListNode(9, l4);
      ListNode l6 = new ListNode(9, l5);
      ListNode l7 = new ListNode(9, l6);

      ListNode listNode = addTwoNumbers(l3, l7);
      System.out.println(listNode);
   }

   private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      return addRecursively(l1, l2, 0);
   }

   private static ListNode addRecursively(ListNode l1, ListNode l2, int counter) {
      int sum = l1.val + l2.val + counter;
      if (sum >= 10) {
         if (Objects.isNull(l1.next) && Objects.isNull(l2.next)) {
            ListNode last0 = new ListNode(1);
            return new ListNode(sum % 10, last0);
         } else if (Objects.isNull(l1.next)) {
            return new ListNode(sum % 10, addRecursively(new ListNode(0), l2.next, sum / 10));
         } else if (Objects.isNull(l2.next)) {
            return new ListNode(sum % 10, addRecursively(l1.next, new ListNode(0), sum / 10));
         } else {
            return new ListNode(sum % 10, addRecursively(l1.next, l2.next, sum / 10));
         }
      } else {
         if (Objects.isNull(l1.next) && Objects.isNull(l2.next)) {
            return new ListNode(sum);
         } else if (Objects.isNull(l1.next)) {
            return new ListNode(sum, addRecursively(new ListNode(0), l2.next, sum / 10));
         } else if (Objects.isNull(l2.next)) {
            return new ListNode(sum, addRecursively(l1.next, new ListNode(0), sum / 10));
         } else {
            return new ListNode(sum, addRecursively(l1.next, l2.next, sum / 10));
         }
      }
   }
   // without recursion
//   private static ListNode addTwoNumbers11(ListNode l1, ListNode l2) {
//      ListNode dummyHead = new ListNode(0);
//      ListNode ln1 = l1;
//      ListNode ln2 = l2;
//      ListNode current = dummyHead;
//      int carry = 0;
//
//      while (ln1 != null || ln2 != null) {
//         int val1 = (ln1 != null) ? ln1.val : 0;
//         int val2 = (ln2 != null) ? ln2.val : 0;
//         int sum = carry + val1 + val2;
//         carry = sum / 10;
//         current.next = new ListNode(sum % 10);
//         current = current.next;
//         if (ln1 != null) {
//            ln1 = ln1.next;
//         }
//         if (ln2 != null) {
//            ln2 = ln2.next;
//         }
//      }
//      if (carry > 0) {
//         current.next = new ListNode(carry);
//      }
//      return dummyHead.next;
//   }

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
