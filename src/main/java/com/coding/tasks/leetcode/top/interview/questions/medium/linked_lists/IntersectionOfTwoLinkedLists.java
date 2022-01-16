package com.coding.tasks.leetcode.top.interview.questions.medium.linked_lists;

public class IntersectionOfTwoLinkedLists {

   public static void main(String[] args) {

      ListNode l4 = new ListNode(4);
      ListNode l3 = new ListNode(3, l4);
      ListNode l2 = new ListNode(2, l3);
      ListNode l1 = new ListNode(1, l2);

      ListNode l6 = new ListNode(6);
      ListNode l7 = new ListNode(7, l6);
      ListNode l5 = new ListNode(5, l7);

      ListNode listNode = getIntersectionNode(l1, l5);

      if (listNode != null) {
         System.out.println(listNode.val);
      } else {
         System.out.println("null");
      }
   }

   private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      int lengthA = 0;
      ListNode lastA = null;
      ListNode tmp = headA;
      while (tmp != null) {
         if (tmp.next == null) {
            lastA = tmp;
         }
         tmp = tmp.next;
         lengthA++;
      }

      int lengthB = 0;
      ListNode lastB = null;
      tmp = headB;
      while (tmp != null) {
         if (tmp.next == null) {
            lastB = tmp;
         }
         tmp = tmp.next;
         lengthB++;
      }

      if (lastA == lastB) {
         if (lengthA > lengthB) {
            return getCommonNode(headA, headB, lengthA - lengthB);
         } else {
            return getCommonNode(headB, headA, lengthB - lengthA);
         }
      } else {
         return null;
      }
   }

   private static ListNode getCommonNode(ListNode longest, ListNode shortest, int diff) {
      ListNode tmpLong = longest;
      int counter = 0;
      while (counter < diff) {
         tmpLong = tmpLong.next;
         counter++;
      }

      ListNode tmpShort = shortest;
      while (tmpShort != tmpLong) {
         tmpLong = tmpLong.next;
         tmpShort = tmpShort.next;
      }
      return tmpLong;
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
