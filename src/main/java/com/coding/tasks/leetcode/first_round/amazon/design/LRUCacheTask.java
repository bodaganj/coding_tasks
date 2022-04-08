package com.coding.tasks.leetcode.first_round.amazon.design;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheTask {

   public static void main(String[] args) {
      LRUCache obj = new LRUCache(2);
      obj.put(1, 1);
      obj.put(2, 2);
      System.out.println(obj.get(1)); // 1
      obj.put(3, 3);
      System.out.println(obj.get(2)); // -1
      obj.put(4, 4);
      System.out.println(obj.get(1)); // -1
      System.out.println(obj.get(3)); // 3
      System.out.println(obj.get(4)); // 4
   }

   /**
    * Your LRUCache object will be instantiated and called as such:
    * LRUCache obj = new LRUCache(capacity);
    * int param_1 = obj.get(key);
    * obj.put(key,value);
    */
   static class LRUCache extends LinkedHashMap<Integer, Integer> {

      private int capacity;

      public LRUCache(int capacity) {
         super(capacity, 0.75F, true);
         this.capacity = capacity;
      }

      public int get(int key) {
         return super.getOrDefault(key, -1);
      }

      public void put(int key, int value) {
         super.put(key, value);
      }

      @Override
      protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
         return super.size() > capacity;
      }
   }
}
