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

//      tmp = reverseKGroup(l1, 2);

      while (tmp != null) {
         System.out.print(tmp.val + " ");
         tmp = tmp.next;
      }
   }

//   private static ListNode reverseKGroup(ListNode head, int k) {
//
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
