package com.coding.tasks.leetcode.third_round.top_interview_questions.medium.linked.lists;

public class IntersectionOfTwoLinkedLists {

   public static void main(String[] args) {

   }

   public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      int lengthA = getLength(headA);
      int lengthB = getLength(headB);
      if (lengthA > lengthB) {
         return getInt(headB, headA, lengthA - lengthB);
      } else {
         return getInt(headA, headB, lengthB - lengthA);
      }
   }

   private int getLength(ListNode head) {
      int length = 0;
      ListNode tmp = head;
      while (tmp != null) {
         length++;
         tmp = tmp.next;
      }
      return length;
   }

   private ListNode getInt(ListNode shortest, ListNode longest, int dif) {
      ListNode sh = shortest;
      ListNode lo = longest;
      while (dif > 0) {
         lo = lo.next;
         dif--;
      }

      while (sh != null && lo != null) {
         if (sh == lo) {
            return lo;
         }
         sh = sh.next;
         lo = lo.next;
      }

      return null;
   }

   public class ListNode {

      int val;
      ListNode next;

      ListNode(int x) {
         val = x;
         next = null;
      }
   }
}
