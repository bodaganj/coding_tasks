package com.coding.tasks.leetcode.second_round.top_interview_questions.easy.linked_list;

public class PalindromeLinkedList {

   public static void main(String[] args) {
      ListNode l3 = new ListNode(1);
      ListNode l2 = new ListNode(2, l3);
      ListNode l1 = new ListNode(1, l2);

//      System.out.println(isPalindrome(l1));
//   }
//
//   private static boolean isPalindrome(ListNode head) {
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
