package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.linked_list;

public class LinkedListCycle {

   public static void main(String[] args) {
      ListNode l3 = new ListNode(3, null);
      ListNode l2 = new ListNode(2, l3);
      ListNode l1 = new ListNode(1, l2);
      System.out.println(hasCycle(l1));

      ListNode l44 = new ListNode(4);
      ListNode l33 = new ListNode(3);
      ListNode l22 = new ListNode(2);
      ListNode l11 = new ListNode(1);
      l11.next = l22;
      l22.next = l33;
      l33.next = l44;
      l44.next = l22;
      System.out.println(hasCycle(l11));
   }

   private static boolean hasCycle(ListNode head) {
      if (head == null || head.next == null) {
         return false;
      }

      ListNode fast = head.next;
      ListNode slow = head;

      while (true) {
         if (fast == slow) {
            return true;
         }

         if (fast.next == null || fast.next.next == null) {
            return false;
         }

         fast = fast.next.next;
         slow = slow.next;
      }
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
