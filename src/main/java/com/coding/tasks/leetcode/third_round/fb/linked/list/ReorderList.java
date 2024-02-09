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
      ListNode reversedNode = reverseList(head);
      ListNode dummy = head;
      while (dummy != null && reversedNode != null) {
         ListNode next = dummy.next;
         dummy.next = reversedNode;
         ListNode reverseNext = reversedNode.next;
         reversedNode.next = next;
         dummy = next;
         reversedNode = reverseNext;
      }
   }

   private static ListNode reverseList(ListNode node) {
      ListNode prev = null;
      ListNode curr = node;
      while (curr != null) {
         ListNode next = curr.next;
         curr.next = prev;
         prev = curr;
         curr = next;
      }
      return prev;
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
