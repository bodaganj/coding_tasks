package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.linked.list;

public class CopyListWithRandomPointer {

   public static void main(String[] args) {
      Node n7 = new Node(7);
      Node n13 = new Node(13);
      Node n11 = new Node(11);
      Node n10 = new Node(10);
      Node n1 = new Node(1);

      n7.next = n13;
      n13.next = n11;
      n11.next = n10;
      n10.next = n1;

      n13.random = n7;
      n11.random = n1;
      n10.random = n11;
      n1.random = n7;

      Node node = copyRandomList(n7);
      while (node != null) {
         System.out.println("val -> " + node.val);
         System.out.println("random ->" + (node.random == null ? null : node.random.val));
         System.out.println();
         node = node.next;
      }
   }

   public static Node copyRandomList(Node head) {
      if (head == null) {
         return null;
      }
      Node tmp = head;
      while (tmp != null) {
         Node next = tmp.next;
         Node newTmp = new Node(tmp.val);
         tmp.next = newTmp;
         newTmp.next = next;
         tmp = next;
      }

      tmp = head;
      while (tmp != null) {
         if (tmp.random != null) {
            tmp.next.random = tmp.random.next;
         }
         tmp = tmp.next.next;
      }

      tmp = head;
      Node ans = head.next;
      Node newTmp = ans;
      while (newTmp != null) {
         tmp.next = tmp.next.next;
         newTmp.next = newTmp.next == null ? null : newTmp.next.next;
         tmp = tmp.next;
         newTmp = newTmp.next;
      }
      return ans;
   }

   private static class Node {

      int val;
      Node next;
      Node random;

      public Node(int val) {
         this.val = val;
         this.next = null;
         this.random = null;
      }
   }
}
