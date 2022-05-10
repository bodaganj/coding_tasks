package com.coding.tasks.leetcode.second_round.google.design;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheTask {

   public static void main(String[] args) {
//      LRUCache o = new LRUCache(2);
//      o.put(1, 1);
//      o.put(2, 2);
//      System.out.println(o.get(1));
//      o.put(3, 3);
//      System.out.println(o.get(2));
//      o.put(4, 4);
//      System.out.println(o.get(1));
//      System.out.println(o.get(3));
//      System.out.println(o.get(4));

      LRUCache o = new LRUCache(2);
      o.put(1, 0);
      o.put(2, 2);
      System.out.println(o.get(1));
      o.put(3, 3);
      System.out.println(o.get(2));
      o.put(4, 4);
      System.out.println(o.get(1));
      System.out.println(o.get(3));
      System.out.println(o.get(4));

//      LRUCache o = new LRUCache(1);
//      o.put(2, 1);
//      System.out.println(o.get(2));
   }

   /**
    * Your LRUCache object will be instantiated and called as such:
    * LRUCache obj = new LRUCache(capacity);
    * int param_1 = obj.get(key);
    * obj.put(key,value);
    */
   static class LRUCache {

      private int capacity;
      private TreeNode head;
      private TreeNode tail;
      private Map<Integer, TreeNode> map;

      public LRUCache(int capacity) {
         this.capacity = capacity;
         this.head = new TreeNode();
         this.tail = new TreeNode();
         this.map = new HashMap<>();
         head.next = tail;
         tail.prev = head;
      }

      public int get(int key) {
         if (map.containsKey(key)) {
            TreeNode node = map.get(key);
            pasteNodeAfterHead(node);
            return node.value;
         } else {
            return -1;
         }
      }

      public void put(int key, int value) {
         if (map.containsKey(key)) {
            TreeNode node = map.get(key);
            node.value = value;
            pasteNodeAfterHead(node);
         } else {
            TreeNode node = new TreeNode(key, value);
            pasteNodeAfterHead(node);
            if (map.size() > capacity) {
               map.remove(tail.prev.key);
               TreeNode prev = tail.prev.prev;
               prev.next = tail;
               tail.prev = prev;
            }
         }
      }

      private void pasteNodeAfterHead(TreeNode node) {
         if (map.containsKey(node.key)) {
            TreeNode currNext = node.next;
            TreeNode currPrev = node.prev;
            currNext.prev = currPrev;
            currPrev.next = currNext;
         }
         map.put(node.key, node);
         TreeNode headNext = head.next;
         head.next = node;
         node.next = headNext;
         node.prev = head;
         headNext.prev = node;
      }
   }

   static class TreeNode {

      public TreeNode prev;
      public TreeNode next;
      public int key;
      public int value;

      public TreeNode(int key, int value) {
         this.key = key;
         this.value = value;
      }

      public TreeNode() {
      }
   }
}
