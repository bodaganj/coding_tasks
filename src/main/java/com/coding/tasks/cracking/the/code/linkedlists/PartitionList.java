package com.coding.tasks.cracking.the.code.linkedlists;

public class PartitionList {

   public static void main(String[] args) {
      ListNode l7 = new ListNode(1, null);
      ListNode l6 = new ListNode(6, l7);
      ListNode l5 = new ListNode(3, l6);
      ListNode l4 = new ListNode(4, l5);
      ListNode l3 = new ListNode(3, l4);
      ListNode l2 = new ListNode(8, l3);
      ListNode l1 = new ListNode(1, l2);

      l1 = partition(l1, 4);
      ListNode tmp = l1;

      while (tmp != null) {
         System.out.println(tmp.val);
         tmp = tmp.next;
      }
   }

   /**
    * Get to list, sort list, return new list node based on list
    * @param node
    * @param k
    * @return
    */
   private static ListNode partition(ListNode node, int k) {
      return null;
   }

   static class ListNode {

      int val;
      ListNode next;

      ListNode(int x) {
         val = x;
         next = null;
      }

      ListNode(int x, ListNode l) {
         val = x;
         next = l;
      }
   }
}
