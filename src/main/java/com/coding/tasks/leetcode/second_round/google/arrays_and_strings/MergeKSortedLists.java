package com.coding.tasks.leetcode.second_round.google.arrays_and_strings;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {

   public static void main(String[] args) {
//      ListNode listNode5 = new ListNode(5);
//      ListNode listNode4 = new ListNode(4, listNode5);
//      ListNode listNode1 = new ListNode(1, listNode4);
//
//      ListNode listNode44 = new ListNode(4);
//      ListNode listNode33 = new ListNode(3, listNode44);
//      ListNode listNode11 = new ListNode(1, listNode33);
//
//      ListNode listNode66 = new ListNode(6);
//      ListNode listNode22 = new ListNode(2, listNode66);
//
//      ListNode res = mergeKLists(new ListNode[]{listNode1, listNode11, listNode22});
//      System.out.println(res);

//      ListNode l1 = new ListNode(1);
//      ListNode res1 = mergeKLists(new ListNode[]{l1});
//      ListNode tmp = res1;
//      while (tmp != null) {
//         System.out.println(tmp.val);
//         tmp = tmp.next;
//      }

//      ListNode l1 = new ListNode(1);
      ListNode res1 = mergeKLists(new ListNode[]{null});
      ListNode tmp = res1;
      while (tmp != null) {
         System.out.println(tmp.val);
         tmp = tmp.next;
      }
   }

   // N - number of all ListNodes (the sum of lengths of all lists) in array
   // K - number of ListNodes in array
   // O(N logK)
   private static ListNode mergeKLists(ListNode[] lists) {
      Queue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(list -> list.val));
      for (ListNode list : lists) { // O(N)
         if (list != null) {
            pq.offer(list); // O(logK)
         }
      }

      ListNode head = new ListNode();
      ListNode tmp = head;
      while (!pq.isEmpty()) {
         ListNode poll = pq.poll();
         if (poll.next != null) {
            pq.offer(poll.next);
         }
         tmp.next = poll;
         tmp = tmp.next;
      }

      return head.next;
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