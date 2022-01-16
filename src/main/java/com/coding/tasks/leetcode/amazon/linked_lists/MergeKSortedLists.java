package com.coding.tasks.leetcode.amazon.linked_lists;

public class MergeKSortedLists {

   public static void main(String[] args) {
      ListNode l3 = new ListNode(3);
      ListNode l1 = new ListNode(1, l3);

      ListNode l5 = new ListNode(5);
      ListNode l4 = new ListNode(4, l5);
      ListNode l2 = new ListNode(2, l4);

      ListNode lsdf5 = new ListNode(7);
      ListNode l235 = new ListNode(4, lsdf5);
      ListNode l1234 = new ListNode(3, l235);
      ListNode l1422 = new ListNode(0, l1234);

//      ListNode listNode = mergeTwoLists(l1, l2);
      ListNode listNode = mergeKLists(new ListNode[]{l1, l2, l1422});

      ListNode tmp = listNode;
      while (tmp != null) {
         System.out.println(tmp.val);
         tmp = tmp.next;
      }
   }

   private static ListNode mergeKLists(ListNode[] lists) {
      if (lists == null || lists.length == 0) {
         return null;
      }
      if (lists.length == 1) {
         return lists[0];
      }

      int counter = 1;
      ListNode merged = lists[0];
      while (counter < lists.length) {
         merged = mergeTwoLists(merged, lists[counter]);
         counter++;
      }

      return merged;
   }

   private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      ListNode fake = new ListNode(0);
      ListNode tmpFake = fake;

      while (l1 != null || l2 != null) {
         int tmpL1Val = l1 != null ? l1.val : Integer.MAX_VALUE;
         int tmpL2Val = l2 != null ? l2.val : Integer.MAX_VALUE;

         if (tmpL1Val > tmpL2Val) {
            tmpFake.next = l2;
            l2 = l2.next;
         } else {
            tmpFake.next = l1;
            l1 = l1.next;
         }

         tmpFake = tmpFake.next;
      }

      return fake.next;
   }

   static public class ListNode {

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
