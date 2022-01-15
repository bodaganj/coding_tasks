package com.coding.tasks.cracking.the.code.linkedlists;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

   public static void main(String[] args) {
      ListNode l7 = new ListNode(6, null);
      ListNode l6 = new ListNode(6, l7);
      ListNode l5 = new ListNode(3, l6);
      ListNode l4 = new ListNode(4, l5);
      ListNode l3 = new ListNode(3, l4);
      ListNode l2 = new ListNode(2, l3);
      ListNode l1 = new ListNode(1, l2);

      removeDuplicates(l1);
      ListNode tmp = l1;

      while (tmp != null) {
         System.out.println(tmp.val);
         tmp = tmp.next;
      }
   }

   private static ListNode removeDuplicates(ListNode head) {
      ListNode tmp = head;
      ListNode prev = null;
      Set<Integer> set = new HashSet<>();

      while (tmp != null) {
         if (set.add(tmp.val)) {
            prev = tmp;
         } else {
            prev.next = tmp.next;
         }
         tmp = tmp.next;
      }

      return head;
   }

   static class ListNode {

      int val;
      ListNode next;

      ListNode(int x) {
         val = x;
         next = null;
      }

      ListNode(int x, ListNode l) {
         val = x;
         next = l;
      }
   }
}
