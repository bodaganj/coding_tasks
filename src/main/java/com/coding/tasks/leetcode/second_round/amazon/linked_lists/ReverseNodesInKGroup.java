package com.coding.tasks.leetcode.second_round.amazon.linked_lists;

public class ReverseNodesInKGroup {

   public static void main(String[] args) {
      ListNode l4 = new ListNode(4, null);
      ListNode l3 = new ListNode(3, l4);
      ListNode l2 = new ListNode(2, l3);
      ListNode l1 = new ListNode(1, l2);

      ListNode tmp = l1;
      while (tmp != null) {
         System.out.print(tmp.val + " ");
         tmp = tmp.next;
      }
      System.out.println();

      ListNode tmp1 = reverseKGroup(l1, 2);
      while (tmp1 != null) {
         System.out.print(tmp1.val + " ");
         tmp1 = tmp1.next;
      }
   }

   private static ListNode reverseKGroup(ListNode head, int k) {
      ListNode tmp = head;
      ListNode kTail = null;

      // Head of the final, modified linked list
      ListNode finalHead = null;

      // Keep going until there are nodes in the list
      while (tmp != null) {
         int count = 0;

         // Start counting nodes from the head
         tmp = head;

         // Find the head of the next k nodes
         while (count < k && tmp != null) {
            tmp = tmp.next;
            count++;
         }

         // If we counted k nodes, reverse them
         if (count == k) {

            // Reverse k nodes and get the new head
            ListNode revHead = reverse(head, k);

            // new_head is the head of the final linked list
            if (finalHead == null) {
               finalHead = revHead;
            }

            // ktail is the tail of the previous block of
            // reversed k nodes
            if (kTail != null) {
               kTail.next = revHead;
            }

            kTail = head;
            head = tmp;
         }
      }

      // attach the final, possibly un-reversed portion
      if (kTail != null) {
         kTail.next = head;
      }

      return finalHead == null ? head : finalHead;
   }

   private static ListNode reverse(ListNode head, int k) {
      ListNode prev = null;
      ListNode curr = head;
      while (k > 0) {
         ListNode next = curr.next;
         curr.next = prev;
         prev = curr;
         curr = next;
         k--;
      }

      return prev;
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
