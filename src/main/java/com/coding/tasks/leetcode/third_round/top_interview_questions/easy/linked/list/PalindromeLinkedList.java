package com.coding.tasks.leetcode.third_round.top_interview_questions.easy.linked.list;

public class PalindromeLinkedList {

   public static void main(String[] args) {
//      ListNode l3 = new ListNode(1);
//      ListNode l2 = new ListNode(2, l3);
//      ListNode l1 = new ListNode(1, l2);
//      System.out.println(isPalindrome(l1));

      //=============================
//      ListNode l2 = new ListNode(2, null);
//      ListNode l1 = new ListNode(1, l2);
//      System.out.println(isPalindrome(l1));

      //==========================
      ListNode l4 = new ListNode(1);
      ListNode l3 = new ListNode(2, l4);
      ListNode l2 = new ListNode(2, l3);
      ListNode l1 = new ListNode(1, l2);
      System.out.println(isPalindrome(l1));

      //================================
//      ListNode l5 = new ListNode(1);
//      ListNode l4 = new ListNode(2, l5);
//      ListNode l3 = new ListNode(3, l4);
//      ListNode l2 = new ListNode(2, l3);
//      ListNode l1 = new ListNode(1, l2);
//      System.out.println(isPalindrome(l1));
   }

   public static boolean isPalindrome(ListNode head) {
      int length = getLength(head);
      if (length < 2) {
         return true;
      }

      ListNode prev = head;
      ListNode curr = head.next;
      for (int i = 1; i < length / 2; i++) {
         prev = prev.next;
         curr = curr.next;
      }

      if (length % 2 == 0) {
         prev.next = null;
         prev.next = reverse(curr);
         return checkPalindrome(head, prev.next);
      } else {
         ListNode tmp = curr.next;
         curr.next = null;
         curr.next = reverse(tmp);
         return checkPalindrome(head, curr.next);
      }
   }

   private static int getLength(ListNode head) {
      ListNode tmp = head;
      int length = 0;
      while (tmp != null) {
         length++;
         tmp = tmp.next;
      }
      return length;
   }

   private static ListNode reverse(ListNode curr) {
      ListNode prev = null;
      while (curr != null) {
         ListNode tmp = curr.next;
         curr.next = prev;
         prev = curr;
         curr = tmp;
      }
      return prev;
   }

   private static boolean checkPalindrome(ListNode head, ListNode halfHead) {
      while (halfHead != null) {
         if (head.val != halfHead.val) {
            return false;
         }
         head = head.next;
         halfHead = halfHead.next;
      }
      return true;
   }

   public static class ListNode {

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
