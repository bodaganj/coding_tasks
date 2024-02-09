package com.coding.tasks.leetcode.third_round.fb.linked.list;

public class ReorderList {

   public static void main(String[] args) {
      ListNode ln5 = new ListNode(5);
      ListNode ln4 = new ListNode(4, ln5);
      ListNode ln3 = new ListNode(3, ln4);
      ListNode ln2 = new ListNode(2, ln3);
      ListNode ln1 = new ListNode(1, ln2);
      ListNode dummy = ln1;
      while (dummy != null) {
         System.out.println(dummy.val);
         dummy = dummy.next;
      }
      System.out.println("===========");
      reorderList(ln1);
      dummy = ln1;
      while (dummy != null) {
         System.out.println(dummy.val);
         dummy = dummy.next;
      }
   }

   public static void reorderList(ListNode head) {
      int length = getLength(head);
      ListNode dummy = head;
      int index = 1;
      int right = 1;
      while (index <= length / 2) {
         ListNode tmp = dummy;
         int count = 0;
         while (count < length - right) {
            tmp = tmp.next;
            count++;
         }

         ListNode dummyNext = dummy.next;
         dummy.next = tmp;
         if (tmp != null) {
            tmp.next = dummyNext;
         }
         dummy = dummyNext;
         index++;
         right += 2;
      }
      dummy.next = null;
   }

   private static int getLength(ListNode head) {
      int length = 0;
      ListNode dummy = head;
      while (dummy != null) {
         length++;
         dummy = dummy.next;
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
