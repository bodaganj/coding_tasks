package com.coding.tasks.leetcode.first_round.google.design;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheTask {

   /**
    * Your LRUCache object will be instantiated and called as such:
    * LRUCache obj = new LRUCache(capacity);
    * int param_1 = obj.get(key);
    * obj.put(key,value);
    */
   static class LRUCache extends LinkedHashMap<Integer, Integer> {

      private int capacity;

      public LRUCache(int capacity) {
         super(capacity, 0.75f, true);
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
         return this.size() > capacity;
      }
   }
}