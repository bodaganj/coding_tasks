package com.coding.tasks.leetcode.google.arrays_and_strings;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

   public static void main(String[] args) {
      ListNode listNode5 = new ListNode(5);
      ListNode listNode4 = new ListNode(4, listNode5);
      ListNode listNode1 = new ListNode(1, listNode4);

      ListNode listNode44 = new ListNode(4);
      ListNode listNode33 = new ListNode(3, listNode44);
      ListNode listNode11 = new ListNode(1, listNode33);

      ListNode listNode66 = new ListNode(6);
      ListNode listNode22 = new ListNode(2, listNode66);

      ListNode res = mergeKLists(new ListNode[]{listNode1, listNode11, listNode22});
      System.out.println(res);
   }

   private static ListNode mergeKLists(ListNode[] lists) {
      if (lists == null || lists.length == 0) {
         return null;
      }

      ListNode dummy = new ListNode(0);
      ListNode tail = dummy;

      PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));
      for (ListNode node : lists) {
         if (node != null) {
            queue.add(node);
         }
      }

      while (!queue.isEmpty()) {
         tail.next = queue.poll();
         tail = tail.next;

         if (tail.next != null) {
            queue.add(tail.next);
         }
      }
      return dummy.next;
   }
}

class ListNode {

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