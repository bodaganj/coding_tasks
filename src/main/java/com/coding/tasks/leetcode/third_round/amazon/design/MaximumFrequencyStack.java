package com.coding.tasks.leetcode.third_round.amazon.design;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumFrequencyStack {

   public static void main(String[] args) {
      FreqStack freqStack = new FreqStack();
      freqStack.push(5);
      freqStack.push(7);
      freqStack.push(5);
      freqStack.push(7);
      freqStack.push(4);
      freqStack.push(5);
      System.out.println(freqStack.pop());
      System.out.println(freqStack.pop());
      System.out.println(freqStack.pop());
      System.out.println(freqStack.pop());
      System.out.println(freqStack.pop());
      System.out.println(freqStack.pop()); // 5 7 5 4 7 5
   }

   static class FreqStack {

      private final Queue<Pair> counters;
      private final Map<Integer, Integer> map;
      private int incrementalCount;

      public FreqStack() {
         incrementalCount = 0;
         counters = new PriorityQueue<>((o1, o2) -> {
            if (o1.count != o2.count) {
               return o2.count - o1.count;
            } else {
               return o2.incrementalCount - o1.incrementalCount;
            }
         });
         map = new HashMap<>();
      }

      public void push(int val) {
         map.put(val, map.getOrDefault(val, 0) + 1);
         counters.add(new Pair(val, map.get(val), incrementalCount++));
      }

      public int pop() {
         Pair currentMax = counters.poll();
         int value = currentMax.value;
         map.put(value, map.get(value) - 1);
         if (map.get(value) == 0) {
            map.remove(value);
         }
         return value;
      }

      record Pair(int value, int count, int incrementalCount) {

      }
   }
}
