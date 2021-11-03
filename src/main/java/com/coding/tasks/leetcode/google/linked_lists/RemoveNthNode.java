package com.coding.tasks.leetcode.google.linked_lists;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RemoveNthNode {

   public static void main(String[] args) {
//      ListNode l5 = new ListNode(5);
//      ListNode l4 = new ListNode(4, l5);
//      ListNode l3 = new ListNode(3, l4);
//      ListNode l2 = new ListNode(2, l3);
      ListNode l2 = new ListNode(2);
      ListNode l1 = new ListNode(1, l2);

      ListNode listNode = removeNthFromEnd(l1, 2);
      System.out.println(listNode);
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
