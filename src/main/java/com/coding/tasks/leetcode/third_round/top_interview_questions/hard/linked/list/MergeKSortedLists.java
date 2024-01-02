package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.linked.list;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {

   public ListNode mergeKLists(ListNode[] lists) {
      ListNode dummy = new ListNode();
      Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
      for (ListNode list : lists) {
         if (list != null) {
            queue.add(list);
         }
      }

      ListNode tmp = dummy;
      while (!queue.isEmpty()) {
         ListNode node = queue.poll();
         tmp.next = node;
         tmp = tmp.next;
         if (node.next != null) {
            queue.add(node.next);
         }
      }
      return dummy.next;
   }

   public class ListNode {

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
