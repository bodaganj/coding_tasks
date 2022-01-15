package com.coding.tasks.cracking.the.code.linkedlists;

public class SumDigitsAsLists {

   public static void main(String[] args) {
      ListNode l7 = new ListNode(1, null);
      ListNode l6 = new ListNode(6, l7);
      ListNode l5 = new ListNode(3, l6);
      ListNode l4 = new ListNode(4, l5);

      ListNode l3 = new ListNode(3, null);
      ListNode l2 = new ListNode(8, l3);
      ListNode l1 = new ListNode(1, l2);

      ListNode sum = sum(l1, l4);

      while (sum != null) {
         System.out.println(sum.val);
         sum = sum.next;
      }
   }

   private static ListNode sum(ListNode first, ListNode second) {
      if (first == null) {
         return second;
      }

      if (second == null) {
         return first;
      }

      ListNode resultList = new ListNode(0, null);
      ListNode tmp = resultList;

      int extraPoint = 0;
      while (first != null || second != null) {

         int firstVal = first == null ? 0 : first.val;
         int secondVal = second == null ? 0 : second.val;
         int sum = firstVal + secondVal + extraPoint;

         first = first == null ? null : first.next;
         second = second == null ? null : second.next;

         int finalVal = sum;
         if (sum > 9) {
            finalVal = sum % 10;
            extraPoint = 1;
         } else {
            extraPoint = 0;
         }
         tmp.next = new ListNode(finalVal, null);
         tmp = tmp.next;
      }

      return resultList.next;
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
