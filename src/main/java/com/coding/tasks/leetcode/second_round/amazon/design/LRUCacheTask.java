package com.coding.tasks.leetcode.second_round.amazon.design;

public class LRUCacheTask {

   public static void main(String[] args) {
      LRUCache obj = new LRUCache(2);
      obj.put(1, 1);
      obj.put(2, 2);
//      System.out.println(obj.get(1)); // 1
//      obj.put(3, 3);
//      System.out.println(obj.get(2)); // -1
//      obj.put(4, 4);
//      System.out.println(obj.get(1)); // -1
//      System.out.println(obj.get(3)); // 3
//      System.out.println(obj.get(4)); // 4
   }

   /**
    * Your LRUCache object will be instantiated and called as such:
    * LRUCache obj = new LRUCache(capacity);
    * int param_1 = obj.get(key);
    * obj.put(key,value);
    */
   static class LRUCache {

      public LRUCache(int capacity) {
      }

//      public int get(int key) {
//      }

      public void put(int key, int value) {
      }
   }
}
