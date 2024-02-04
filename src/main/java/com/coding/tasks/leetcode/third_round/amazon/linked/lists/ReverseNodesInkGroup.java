package com.coding.tasks.leetcode.third_round.amazon.linked.lists;

public class ReverseNodesInkGroup {

   public static void main(String[] args) {
      ListNode l5 = new ListNode(5, null);
      ListNode l4 = new ListNode(4, l5);
      ListNode l3 = new ListNode(3, l4);
      ListNode l2 = new ListNode(2, l3);
      ListNode l1 = new ListNode(1, l2);

      ListNode tmp = l1;
      while (tmp != null) {
         System.out.print(tmp.val + " ");
         tmp = tmp.next;
      }

      tmp = reverseKGroup(l1, 2);
      System.out.println();

      while (tmp != null) {
         System.out.print(tmp.val + " ");
         tmp = tmp.next;
      }
   }

   public static ListNode reverseKGroup(ListNode head, int k) {
      ListNode root = new ListNode();
      root.next = head;
      ListNode prev;
      ListNode dummy = root;
      ListNode node = root.next;
      while (node != null) {
         // check if there are k nodes to the right
         ListNode checkLength = node;
         int counter = 0;
         while (checkLength != null && counter < k) {
            counter++;
            checkLength = checkLength.next;
         }
         if (counter != k) {
            break;
         }
         // prev = next after k-th node
         prev = checkLength;

         // reverse nodes (prev != null, but next after k-th node)
         ListNode reversedHead = reverse(node, prev, k);

         // assign dummy.next = prev
         dummy.next = reversedHead;

         // update dummy (first node to start next loop with)
         dummy = node;
         node = checkLength;
      }

      return root.next;
   }

   private static ListNode reverse(ListNode head, ListNode prev, int k) {
      ListNode node = head;
      int i = 0;
      while (i < k) {
         ListNode next = node.next;
         node.next = prev;
         prev = node;
         node = next;
         i++;
      }
      return prev;
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
