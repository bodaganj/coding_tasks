package com.coding.tasks.leetcode.first_round.top_interview_questions.easy.linked_list;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

   public static void main(String[] args) {
//      ListNode l3 = new ListNode(1);
//      ListNode l2 = new ListNode(2, l3);
//      ListNode l1 = new ListNode(1, l2);
//      System.out.println(hasCycle(l1));
   }

   private static boolean hasCycle(ListNode head) {
      Set<ListNode> set = new HashSet<>();

      ListNode tmp = head;
      while (tmp != null) {
         if (!set.add(tmp)) {
            return true;
         }
         tmp = tmp.next;
      }
      return false;
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
