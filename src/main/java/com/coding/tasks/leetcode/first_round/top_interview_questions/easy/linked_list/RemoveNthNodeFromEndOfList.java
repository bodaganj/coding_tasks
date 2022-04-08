package com.coding.tasks.leetcode.first_round.top_interview_questions.easy.linked_list;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RemoveNthNodeFromEndOfList {

   public static void main(String[] args) {
      ListNode l3 = new ListNode(3, null);
      ListNode l2 = new ListNode(2, l3);
//      ListNode l2 = new ListNode(2, null);
      ListNode l1 = new ListNode(1, l2);

      ListNode tmp = l1;
      while (tmp != null) {
         System.out.print(tmp.val + " ");
         tmp = tmp.next;
      }
//      tmp = removeNthFromEnd(l1, 2);
      tmp = removeNthFromEnd(l1, 3);
      System.out.println();

      while (tmp != null) {
         System.out.print(tmp.val + " ");
         tmp = tmp.next;
      }
// ==============
      System.out.println();
      tmp = l3;
      while (tmp != null) {
         System.out.print(tmp.val + " ");
         tmp = tmp.next;
      }
//      tmp = removeNthFromEnd(l1, 2);
      tmp = removeNthFromEnd(l3, 1);
      System.out.println();

      while (tmp != null) {
         System.out.print(tmp.val + " ");
         tmp = tmp.next;
      }
   }

   private static ListNode removeNthFromEnd(ListNode head, int n) {
      if (head == null || head.next == null) {
         return null;
      }
      Map<Integer, ListNode> map = new HashMap<>();
      int counter = 0;
      ListNode fake = new ListNode(0, head);
      ListNode tmp = fake;

      while (!Objects.isNull(tmp)) {
         counter++;
         map.put(counter, tmp);
         tmp = tmp.next;
      }

      map.get(counter - n).next = map.get(counter - n + 1).next;
      return fake.next;
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

