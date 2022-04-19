package com.coding.tasks.leetcode.second_round.top_interview_questions.medium.linked_lists;

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
      if (headA == null || headB == null) {
         return null;
      }

      // Get length of both lists
      ListNode tmpA = headA;
      int lengthA = getLength(tmpA);

      ListNode tmpB = headB;
      int lengthB = getLength(tmpB);

      // Go to certain node of the biggest list to have the same size as small list
      // (e.g. go to 4th node of list with 8 nodes and to 1st of list with 5 nodes)
      if (lengthA < lengthB) {
         while (lengthB != lengthA) {
            lengthB--;
            tmpB = tmpB.next;
         }
      } else {
         while (lengthB != lengthA) {
            lengthA--;
            tmpA = tmpA.next;
         }
      }

      // Compare nodes one by one. If equal - return node
      while (tmpA != tmpB) {
         tmpA = tmpA.next;
         tmpB = tmpB.next;
      }

      return tmpA;
   }

   private static int getLength(ListNode head) {
      int length = 1;
      ListNode tmp = head;
      while (tmp != null) {
         tmp = tmp.next;
         length++;
      }
      return length;
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
