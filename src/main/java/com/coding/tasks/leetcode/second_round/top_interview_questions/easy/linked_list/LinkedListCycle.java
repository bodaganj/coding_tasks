package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.linked_list;

public class LinkedListCycle {

   public static void main(String[] args) {
//      ListNode l3 = new ListNode(1);
//      ListNode l2 = new ListNode(2, l3);
//      ListNode l1 = new ListNode(1, l2);
//      System.out.println(hasCycle(l1));
   }

//   private static boolean hasCycle(ListNode head) {
//   }

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
