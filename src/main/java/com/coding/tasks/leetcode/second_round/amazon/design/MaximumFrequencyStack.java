package com.coding.tasks.leetcode.second_round.amazon.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumFrequencyStack {

   public static void main(String[] args) {
      FreqStack o = new FreqStack();
      o.push(5);
      o.push(7);
      o.push(5);
      o.push(7);
      o.push(4);
      o.push(5);
      System.out.println(o.pop());
      System.out.println(o.pop());
      System.out.println(o.pop());
      System.out.println(o.pop());
   }

   /**
    * Your FreqStack object will be instantiated and called as such:
    * FreqStack obj = new FreqStack();
    * obj.push(val);
    * int param_2 = obj.pop();
    */
   static class FreqStack {

      private Map<Integer, Integer> map;
      private List<int[]> list;
      private Queue<Integer> pq;

      public FreqStack() {
         map = new HashMap<>();
         list = new ArrayList<>();
         pq = new PriorityQueue<>(Collections.reverseOrder());
      }

      public void push(int val) {
         if (map.containsKey(val)) {
            int count = map.get(val) + 1;
            map.put(val, count);
            list.add(new int[]{val, count});
            pq.offer(count);
         } else {
            map.put(val, 1);
            list.add(new int[]{val, 1});
            pq.offer(1);
         }
      }

      public int pop() {
         Integer count = pq.poll();
         for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i)[1] == count) {
               int ans = list.get(i)[0];
               int newCount = map.get(ans) - 1;
               if (newCount > 0) {
                  map.put(ans, newCount);
               } else {
                  map.remove(ans);
               }
               list.remove(i);
               return ans;
            }
         }

         return -1;
      }
   }
}
