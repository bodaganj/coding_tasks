package com.coding.tasks.leetcode.top.interview.questions.easy.linked_list;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList {

   public static void main(String[] args) {
      ListNode l3 = new ListNode(3, null);
      ListNode l2 = new ListNode(2, l3);
      ListNode l1 = new ListNode(1, l2);

      ListNode tmp = l1;
      while (tmp != null) {
         System.out.print(tmp.val + " ");
         tmp = tmp.next;
      }

      tmp = reverseList(l1);
      System.out.println();

      while (tmp != null) {
         System.out.print(tmp.val + " ");
         tmp = tmp.next;
      }
   }

   private static ListNode reverseList(ListNode head) {
      List<ListNode> list = new ArrayList<>();
      ListNode tmp = head;
      while (tmp != null) {
         list.add(tmp);
         tmp = tmp.next;
      }
      list.get(0).next = null;

      ListNode fake = new ListNode(0, null);
      tmp = fake;
      for (int i = list.size() - 1; i >= 0; i--) {
         tmp.next = list.get(i);
         tmp = tmp.next;
      }

      return fake.next;
   }

   /**
    * The best solution!!!!
    */
//   private static ListNode reverseList(ListNode head) {
//      ListNode prev = null;
//      ListNode curr = head;
//      while (curr != null) {
//         ListNode nextTemp = curr.next;
//         curr.next = prev;
//         prev = curr;
//         curr = nextTemp;
//      }
//      return prev;
//   }

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
