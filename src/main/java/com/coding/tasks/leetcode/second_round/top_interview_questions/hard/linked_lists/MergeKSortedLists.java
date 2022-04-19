package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.linked_lists;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {

   public static void main(String[] args) {
      ListNode l6 = new ListNode(6);
      ListNode l2 = new ListNode(2, l6);

      ListNode l5 = new ListNode(5);
      ListNode l4 = new ListNode(4, l5);
      ListNode l1 = new ListNode(1, l4);

      ListNode l44 = new ListNode(4);
      ListNode l3 = new ListNode(3, l44);
      ListNode l11 = new ListNode(1, l3);

      ListNode listNode = mergeKLists(new ListNode[]{l1, l2, l11});

      while (listNode != null) {
         System.out.println(listNode.val);
         listNode = listNode.next;
      }
   }

   private static ListNode mergeKLists(ListNode[] lists) {
      if (lists == null) {
         return null;
      }

      Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
      for (ListNode list : lists) {
         if (list != null) {
            queue.offer(list);
         }
      }

      ListNode dummy = new ListNode(0);
      ListNode tmp = dummy;
      while (!queue.isEmpty()) {
         ListNode poll = queue.poll();
         if (poll.next != null) {
            queue.offer(poll.next);
         }

         tmp.next = poll;
         tmp = tmp.next;
      }

      return dummy.next;
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
