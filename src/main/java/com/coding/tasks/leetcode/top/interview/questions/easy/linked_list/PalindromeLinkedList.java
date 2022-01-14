package com.coding.tasks.leetcode.top.interview.questions.easy.linked_list;

public class PalindromeLinkedList {

   public static void main(String[] args) {
      ListNode l3 = new ListNode(1);
      ListNode l2 = new ListNode(2, l3);
      ListNode l1 = new ListNode(1, l2);

      System.out.println(isPalindrome(l1));
   }

   private static boolean isPalindrome(ListNode head) {
      if (head.next == null) {
         return true;
      }

      StringBuilder sb = new StringBuilder();
      ListNode fake = head;
      while (fake != null) {
         sb.append(fake.val);
         fake = fake.next;
      }

      return sb.toString().equals(sb.reverse().toString());
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
