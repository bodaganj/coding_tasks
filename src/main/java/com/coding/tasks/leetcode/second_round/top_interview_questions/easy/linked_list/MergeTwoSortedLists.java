package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.linked_list;

public class MergeTwoSortedLists {

   public static void main(String[] args) {
      ListNode l4 = new ListNode(4, null);
      ListNode l2 = new ListNode(2, l4);
      ListNode l1 = new ListNode(1, l2);

      ListNode l44 = new ListNode(4, null);
      ListNode l33 = new ListNode(3, l44);
      ListNode l11 = new ListNode(1, l33);

//      ListNode listNode = mergeTwoLists(l1, l11);
//
//      ListNode tmp = listNode;
//      while (tmp != null) {
//         System.out.println(tmp.val);
//         tmp = tmp.next;
//      }
//   }
//
//   private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
