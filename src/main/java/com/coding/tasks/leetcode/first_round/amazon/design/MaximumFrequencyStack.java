package com.coding.tasks.leetcode.first_round.amazon.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

      public List<Pair> pairList;
      public Queue<Pair> sort;
      public Map<Integer, Integer> map;

      public FreqStack() {
         pairList = new ArrayList<>();
         sort = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparingInt(pair -> pair.counter)));
         map = new HashMap<>();
      }

      public void push(int val) {
         map.put(val, map.getOrDefault(val, 0) + 1);

         Integer count = map.get(val);
         Pair pair = new Pair(val, count);
         sort.offer(pair);
         pairList.add(pair);
      }

      public int pop() {
         Pair poll = sort.poll();
         int topCount = poll.counter;

         int ans = 0;
         for (int i = pairList.size() - 1; i >= 0; i--) {
            if (pairList.get(i).counter == topCount) {
               ans = pairList.get(i).value;
               pairList.remove(i);
               break;
            }
         }

         map.put(ans, map.get(ans) - 1);
         if (map.get(ans) == 0) {
            map.remove(ans);
         }

         return ans;
      }

      static class Pair {

         public int value;
         public int counter;

         public Pair(int value, int counter) {
            this.value = value;
            this.counter = counter;
         }

         @Override
         public int hashCode() {
            return value * 31 + counter;
         }

         @Override
         public boolean equals(Object ob) {
            if (ob.getClass() != Pair.class) {
               return false;
            }
            Pair second = (Pair) ob;
            return this.value == second.value && this.counter == second.counter;
         }
      }
   }
}
