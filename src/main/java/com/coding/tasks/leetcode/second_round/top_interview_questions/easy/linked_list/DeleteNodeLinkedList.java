package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.linked_list;

public class DeleteNodeLinkedList {

   public static void main(String[] args) {
      ListNode l4 = new ListNode(4);
      ListNode l3 = new ListNode(3, l4);
      ListNode l2 = new ListNode(2, l3);
      ListNode l1 = new ListNode(1, l2);

      ListNode tmp = l1;
      while (tmp != null) {
         System.out.println(tmp.val);
         tmp = tmp.next;
      }

      deleteNode(l3);

      tmp = l1;
      while (tmp != null) {
         System.out.println(tmp.val);
         tmp = tmp.next;
      }
   }

   private static void deleteNode(ListNode node) {
   }

   static class ListNode {

      int val;
      ListNode next;

      ListNode(int x) {
         val = x;
      }

      ListNode(int x, ListNode next) {
         val = x;
         this.next = next;
      }
   }
}
