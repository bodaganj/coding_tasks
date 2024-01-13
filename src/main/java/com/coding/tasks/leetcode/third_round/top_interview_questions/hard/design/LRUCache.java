package com.coding.tasks.leetcode.third_round.top_interview_questions.hard.design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LRUCache {

   private final int capacity;
   private final Map<Integer, Integer> map;
   private final Map<Integer, Integer> counter;
   private final Queue<Integer> queue;

   public LRUCache(int capacity) {
      this.capacity = capacity;
      map = new HashMap<>();
      counter = new HashMap<>();
      queue = new LinkedList<>();
   }

   public static void main(String[] args) {
      LRUCache cache = new LRUCache(2);
//      cache.put(1, 1);
//      cache.put(2, 2);
//      System.out.println(cache.get(1));
//      cache.put(3, 3);
//      System.out.println(cache.get(2));
//      cache.put(4, 4);
//      System.out.println(cache.get(1));
//      System.out.println(cache.get(3));
//      System.out.println(cache.get(4));

      System.out.println(cache.get(2));
      cache.put(2, 6);
      System.out.println(cache.get(1));
      cache.put(1, 5);
      cache.put(1, 2);
      System.out.println(cache.get(1));
      System.out.println(cache.get(2));
   }

   public int get(int key) {
      if (map.containsKey(key)) {
         queue.add(key);
         counter.put(key, counter.getOrDefault(key, 0) + 1);
         return map.get(key);
      } else {
         return -1;
      }
   }

   public void put(int key, int value) {
      if (!map.containsKey(key) && map.size() == capacity) {
         while (map.size() == capacity) {
            Integer poll = queue.poll();
            if (counter.get(poll) == 1) {
               counter.remove(poll);
               map.remove(poll);
            } else {
               counter.put(poll, counter.get(poll) - 1);
            }
         }
      }
      queue.add(key);
      counter.put(key, counter.getOrDefault(key, 0) + 1);
      map.put(key, value);
   }
}
