package com.coding.tasks.leetcode.second_round.top_interview_questions.hard.design;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheTask {

   public static void main(String[] args) {
      LRUCache o = new LRUCache(2);
      o.put(1, 1);
      o.put(2, 2);
      System.out.println(o.get(1));
      o.put(3, 3);
      System.out.println(o.get(2));
      o.put(4, 4);
      System.out.println(o.get(1));
      System.out.println(o.get(3));
      System.out.println(o.get(4));
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
      public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
         return super.size() > this.capacity;
      }
   }
}
